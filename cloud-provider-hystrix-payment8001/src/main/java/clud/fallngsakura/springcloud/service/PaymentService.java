package clud.fallngsakura.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
        }
    )
    public String paymentInfoTimeOut(Integer id)
    {
        // 延迟
        try{
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfoTimeOut"
                +id+"\t"+"哈哈 耗时3秒钟";

        // 异常
        /*int i = 10 / 0;
        return "线程池："+Thread.currentThread().getName()+"paymentInfoOK"
                +id+"\t"+"哈哈 耗时3秒钟";*/
    }

    public String paymentInfoTimeOutHandler(Integer id)
    {
        return "线程池："+Thread.currentThread().getName()+"paymentInfoTimeOut"
                +id+"\t"+"8001 服务繁忙";
    }
}
