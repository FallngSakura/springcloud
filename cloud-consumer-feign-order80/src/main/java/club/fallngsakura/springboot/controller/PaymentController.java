package club.fallngsakura.springboot.controller;

import club.fallngsakura.springboot.serivce.PaymentFeignService;
import club.fallngsakura.springcloud.entities.CommonResult;
import club.fallngsakura.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MISAKI RINNE
 */

@RestController
@Slf4j
public class PaymentController
{

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public Integer feignTimeOut(){
        //openFeign 一般默认1秒
        return paymentFeignService.feignTimeOut();
    }
}
