package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@LoadBalancerClients({@LoadBalancerClient(name = "provider")})
public class ConsumerApplication13000 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication13000.class,args);
    }
}
