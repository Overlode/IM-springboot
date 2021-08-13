package com.IM.springboot_mybatis.service.impl;

import com.IM.springboot_mybatis.entity.Comment;
import com.IM.springboot_mybatis.mapper.CommentMapper;
import com.IM.springboot_mybatis.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    @Override
    public Integer likeComment(Integer userId, Integer commentId) {
        return commentMapper.likeComment(userId,commentId);
    }

    @Override
    public Integer cancelLikeComment(Integer userId, Integer commentId) {
        return commentMapper.cancelLikeComment(userId, commentId);
    }

    @Override
    public Integer addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public Integer deleteCommentByCommentId(Integer commentId) {
        return commentMapper.deleteCommentByCommentId(commentId);
    }

    @Override
    public List<Comment> getCommentByPostId(Integer askId, Integer postId) {
        return commentMapper.getCommentByPostId(askId, postId);
    }
}
