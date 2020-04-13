package clud.fallngsakura.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * PaymentService
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
@Service
public class PaymentService {
    /**
     * 成功
     * @param id
     * @return
     */
    public String paymentinfook(Integer id)
    {
        return "线程池："+Thread.currentThread().getName()+"paymentInfoOK"
                +id+"\t"+"哈哈";
    }

    /**
     *  超时
     * @param id
     * @return
     */
    public String paymentInfoTimeOut(Integer id)
    {
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfoOK"
                +id+"\t"+"哈哈 耗时3秒钟";
    }

}
