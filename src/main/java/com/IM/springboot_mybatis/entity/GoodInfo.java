package com.IM.springboot_mybatis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EntityScan
@NoArgsConstructor
@AllArgsConstructor
public class GoodInfo {
    int goodId;
    int amount;
    double price;
    String goodName;
    String goodDetail;
    int shopId;
    String image3;
    String image4;
    String image1;
    String image2;
    int categoryId;
}
