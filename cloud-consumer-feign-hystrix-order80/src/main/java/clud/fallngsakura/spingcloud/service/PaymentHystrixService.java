package clud.fallngsakura.spingcloud.service;

import clud.fallngsakura.spingcloud.service.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * PaymentService
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT",fallback = PaymentHystrixServiceImpl.class)
@Service
public interface PaymentHystrixService {

    /**
     * 测试调用超时延迟
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id")Integer id);

    /**
     * 测试调用成功
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id")Integer id);

}
