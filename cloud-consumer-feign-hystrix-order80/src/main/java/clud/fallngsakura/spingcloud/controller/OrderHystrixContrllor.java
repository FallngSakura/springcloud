package clud.fallngsakura.spingcloud.controller;

import clud.fallngsakura.spingcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
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
public class OrderHystrixContrllor {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentinfook(@PathVariable Integer id)
    {
        return paymentHystrixService.paymentinfook(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable Integer id)
    {
        return paymentHystrixService.paymentInfoTimeOut(id);
    }

}
