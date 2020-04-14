package clud.fallngsakura.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * OrderMain80
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {

    public static void main(String[] args)
    {
        SpringApplication.run(OrderConsulMain80.class,args);
    }

}
