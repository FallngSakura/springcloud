package clud.fallngsakura.springcloud.controller;

import clud.fallngsakura.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PaymentController
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    
    @Value("${server.port}")
    private String serverPort;
    
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentinfook(@PathVariable Integer id)
    {
        String result = paymentService.paymentinfook(id);
        log.info("{result:"+result+"}");
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable Integer id)
    {
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("{result:"+result+"}");
        return result;
    }

}
