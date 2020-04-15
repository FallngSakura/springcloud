package clud.fallngsakura.spingcloud.service.impl;

import clud.fallngsakura.spingcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * PaymentHystrixServiceImpl
 *
 * @author MISAKI RINNE
 * @version 1.0
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "PaymentHystrixServiceImpl : paymentInfoTimeOut 服务繁忙";
    }

    @Override
    public String paymentInfoOK(Integer id) {
        return "PaymentHystrixServiceImpl : paymentInfoOK 服务繁忙";
    }
}
