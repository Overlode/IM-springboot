package com.IM.springboot_mybatis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.io.Serializable;

@Data
@EntityScan
@NoArgsConstructor
public class User implements Serializable {
    private Integer userId;
    private String email;
    private String username;
    private String password;
    private String profileImg;
    private String bio;
    private String birthDay;
    private Integer gender;
    private String city;
    private String backgroundImg;
    private Integer postCount;
    private Integer fanCount;
    private Integer followCount;
    private Integer isFollow;
    private double money;
    private double longitude;
    private double latitude;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", bio='" + bio + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", backgroundImg='" + backgroundImg + '\'' +
                ", postCount=" + postCount +
                ", fanCount=" + fanCount +
                ", followCount=" + followCount +
                ", isFollow=" + isFollow +
                ", money="+ money +
                '}';
    }
}
