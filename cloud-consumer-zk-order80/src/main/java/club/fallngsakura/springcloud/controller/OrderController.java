package club.fallngsakura.springcloud.controller;

import club.fallngsakura.springcloud.entities.CommonResult;
import club.fallngsakura.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * OrderController
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
@RestController
public class OrderController {

    public static final String PAYMENT_URL="http://cloud-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPayment()
    {
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }
}
