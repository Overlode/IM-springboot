package com.IM.springboot_mybatis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.List;

@Data
@EntityScan
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    private Integer commentId;
    private Integer userId;
    private Integer postId;
    private String profileImg;
    private String username;
    private String date;
    private String comment;
    private String image;
    private Integer isLiked;
    private Integer likeCount;
    private Integer replyCount;
    private List<Reply> replyList;
}
