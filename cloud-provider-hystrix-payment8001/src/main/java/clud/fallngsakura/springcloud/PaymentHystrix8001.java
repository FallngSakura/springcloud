package clud.fallngsakura.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * PaymentHystris8001
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
@SpringBootApplication
@EnableCircuitBreaker
public class PaymentHystrix8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrix8001.class,args);
    }

}
