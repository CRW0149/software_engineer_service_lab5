package example.feign;

import example.entity.Order;
import example.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("provider")
public interface ProviderServer {
    @GetMapping("/order/getOrderByUserId")
    public Result<Order>getOrderByUserId(@RequestParam(name = "userId")Integer userId);
}
