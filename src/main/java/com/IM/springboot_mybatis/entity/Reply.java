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
public class Reply implements Serializable {
    private Integer replyId;
    private Integer commentId;
    private Integer userId;
    private Integer likeCount;
    private String profileImg;
    private String username;
    private String beReplyName;
    private String date;
    private String text;
    private String imageUrl;
    private Integer isLiked;
    private Integer LikeNum;
}
