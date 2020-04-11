package club.fallngsakura.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * LoadBalancer
 *
 * @author MISAKI RINNE
 * @version 1.0
 **/
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
