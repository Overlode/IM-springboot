package com.IM.springboot_mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;

@Data
@EntityScan
@NoArgsConstructor
@AllArgsConstructor
public class Feedback implements Serializable {
    private Integer feedbackId;
    private Integer forwardId;
    private Integer orderId;
    private Integer userId;
    private Integer goodId;
    private String profileImg;
    private String username;
    private String date;
    private String feedback;
    private String image;
}
