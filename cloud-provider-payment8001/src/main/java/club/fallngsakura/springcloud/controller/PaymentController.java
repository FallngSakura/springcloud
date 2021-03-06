package club.fallngsakura.springcloud.controller;

import club.fallngsakura.springcloud.entities.CommonResult;
import club.fallngsakura.springcloud.entities.Payment;
import club.fallngsakura.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author MISAKI RINNE
 */

@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private Integer serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("create结果："+result);
        if(result > 0 )
        {
            return  new CommonResult(200,"插入数据库成功,端口："+serverPort,result);
        }else{
            return  new CommonResult(444,"插入数据库失败",null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment);
        if(payment != null )
        {
            return  new CommonResult(200,"查询成功,端口："+serverPort,payment);
        }else{
            return  new CommonResult(444,"没有对应记录，查询id:"+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> service = discoveryClient.getServices();

        for (String elemnt : service){
            log.info("{elemnt:"+elemnt+"}");
        }

        List<ServiceInstance> instancess = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instances : instancess){
            log.info("{serviceId:"+instances.getInstanceId()+
                    ",Host:"+instances.getHost()+",Port:"+instances.getPort()+",url:"+instances.getUri()+"}");
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public Object getlb(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public Integer feignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
