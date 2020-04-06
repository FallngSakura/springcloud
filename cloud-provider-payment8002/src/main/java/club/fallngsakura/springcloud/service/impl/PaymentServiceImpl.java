package club.fallngsakura.springcloud.service.impl;

import club.fallngsakura.springcloud.dao.PaymentDao;
import club.fallngsakura.springcloud.entities.Payment;
import club.fallngsakura.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author MISAKI RINNE
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
