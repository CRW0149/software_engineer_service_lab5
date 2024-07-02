package example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Order implements Serializable {
    private Integer userId;
    private Integer id;
    private Double total;
    private String address;
}
