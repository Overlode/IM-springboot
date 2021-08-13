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
public class Post implements Serializable {

    private Integer postId;
    private Integer userId;
    private String username;
    private String date;
    private String text;
    private String imageUrl;
    private String profileImg;
    private Integer likeCount;
    private Integer commentCount;
    private Integer forwardCount;
    private Integer isLiked;
    private Integer isStar;
    private Integer forwardId;
    private String forwardName;
    private String forwardText;
    private String forwardImageUrl;
}
