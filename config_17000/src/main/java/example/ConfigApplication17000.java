package example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//配置中心服务注解
public class ConfigApplication17000 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication17000.class,args);
    }
}
