package club.fallngsakura.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ApplictionConetextConfig
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/

@Configuration
public class ApplicationContextConfig
{
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
