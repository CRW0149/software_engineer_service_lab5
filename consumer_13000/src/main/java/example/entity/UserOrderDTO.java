package example.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data

public class UserOrderDTO implements Serializable {
    private String name;
    private Integer userId;
    private Integer age;

    private Integer orderId;
    private Double total;
    private String address;
}
