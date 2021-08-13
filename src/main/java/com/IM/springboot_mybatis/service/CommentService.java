package com.IM.springboot_mybatis.service;

import com.IM.springboot_mybatis.entity.Comment;

import java.util.List;

public interface CommentService {

    Integer likeComment(Integer userId ,Integer commentId);

    Integer cancelLikeComment(Integer userId ,Integer commentId);

    Integer addComment(Comment comment);

    Integer deleteCommentByCommentId(Integer commentId);

    List<Comment> getCommentByPostId(Integer askId,Integer postId);
}
