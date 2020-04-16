package clud.fallngsakura.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String paymentInfoOK(Integer id)
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


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") // 百分比 失败率
    }

    )
    public String paymentCircuitBreaker(@PathVariable Integer id)
    {
        if(id < 0 )
        {
            throw new RuntimeException("id为负数");
        }
        String serialNumber = IdUtil.simpleUUID(); // 生成不带 - 的uuid
        return  Thread.currentThread().getName() + " \t " + "调用成功 ，流水号：" + serialNumber ;
    }
    public String paymentCircuitBreaker_Fallback(Integer id)
    {
        return "id 不能为负数";
    }
}
