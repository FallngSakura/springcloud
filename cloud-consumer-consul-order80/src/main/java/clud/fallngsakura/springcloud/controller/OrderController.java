package clud.fallngsakura.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://consul-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getPayment()
    {
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
