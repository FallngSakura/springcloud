package club.fallngsakura.springboot.confg;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignConfig
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
@Configuration
public class FeignConfig {

    /**
     * 配置 fegin日志级别
     * @return
     */
    @Bean
    Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;
    }
}
