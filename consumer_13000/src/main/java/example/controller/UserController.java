package example.controller;


import example.entity.Order;
import example.entity.Result;
import example.entity.User;
import example.entity.UserOrderDTO;
import example.feign.ProviderServer;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@RefreshScope
public class UserController {
    @Resource
    private ProviderServer providerServer;
    @GetMapping("/getUserById")
    public Result<UserOrderDTO> getUserById(@RequestParam(name = "userId")Integer userId){
        User user=new User("陈汝卫",userId,21);
        //远程调用
        Result<Order>orderResult=providerServer.getOrderByUserId(userId);
        Order order=orderResult.getData();

        UserOrderDTO userOrderDTO=new UserOrderDTO();
        BeanUtils.copyProperties(order,userOrderDTO);
        BeanUtils.copyProperties(user,userOrderDTO);
        userOrderDTO.setOrderId(order.getId());

        return Result.success(userOrderDTO,"消费者13000"+orderResult.getMessage());
    }
    @Value("${mes}")
    private String mes;
    @GetMapping("/testBus")
    public String testBus(){
        return mes;
    }
}
