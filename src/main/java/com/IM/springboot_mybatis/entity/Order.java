package com.IM.springboot_mybatis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EntityScan
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    int orderId;
    int goodId;
    int amount;
    double price;
    int userId;
    int state;//0待付款 1待发货 2待收货 3待评价
    String goodName;
    String image1;
    String address;
    String username;
}
