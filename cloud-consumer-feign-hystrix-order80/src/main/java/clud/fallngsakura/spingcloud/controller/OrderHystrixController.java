package clud.fallngsakura.spingcloud.controller;

import clud.fallngsakura.spingcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * OrderContrllor
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentinfook(@PathVariable Integer id)
    {
        String result = paymentService.paymentinfook(id);
        log.info("{result:"+result+"}");
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallBaclMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
            }
    )
    public String paymentInfoTimeOut(@PathVariable Integer id)
    {
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("{result:"+result+"}");
        return result;
    }
    public String paymentInfoTimeOutFallBaclMethod(Integer id)
    {
        return "线程池："+Thread.currentThread().getName()+"paymentInfoTimeOut"
                +id+"\t"+"80 服务繁忙";
    }
}
