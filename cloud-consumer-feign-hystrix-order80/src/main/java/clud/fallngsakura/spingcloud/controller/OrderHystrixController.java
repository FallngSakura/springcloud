package clud.fallngsakura.spingcloud.controller;

import clud.fallngsakura.spingcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * OrderHystrixController
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable Integer id)
    {
        String result = paymentService.paymentInfoOK(id);
        log.info("{result:"+result+"}");
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable Integer id)
    {
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("{result:"+result+"}");
        return result;
    }
    public String defaultFallback()
    {
        return "线程池："+Thread.currentThread().getName()+"\t 服务80繁忙";
    }

}
