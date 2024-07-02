package example.controller;

import example.entity.Order;
import example.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/getOrderByUserId")
    public Result<Order>getOrderByUserId(@RequestParam(name = "userId")Integer userId){
        Order order=new Order(userId,111001,299.9,"云南大学");
        return Result.success(order,"服务提供者11000");
    }
}
