package club.fallngsakura.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MISAKI RINNE
 * @version 1.0
 * @NAME: GateWayConfig
 * @date 2020/4/18 16:37
 */
@Configuration
public class GateWayConfig
{
    /**
     * 配置GateWay路由
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_misaki",
                r -> r.path("/**") //断言，路径相匹配的进行路由
                        .uri("https://www.fallngsakura.club")).build(); //路由地址

        return routes.build();
    }
}
