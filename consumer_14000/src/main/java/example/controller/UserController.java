package example.controller;


import example.entity.Order;
import example.entity.Result;
import example.entity.User;
import example.entity.UserOrderDTO;
import example.feign.ProviderServer;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
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

        return Result.success(userOrderDTO,"消费者14000"+orderResult.getMessage());
    }

}
