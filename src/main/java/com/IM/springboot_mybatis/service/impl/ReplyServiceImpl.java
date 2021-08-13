package com.IM.springboot_mybatis.service.impl;

import com.IM.springboot_mybatis.entity.Reply;
import com.IM.springboot_mybatis.mapper.ReplyMapper;
import com.IM.springboot_mybatis.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper ;
    @Autowired
    public ReplyServiceImpl( ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }
    @Override
    public List<Reply> getReplyByCommentId(Integer askId, Integer commentId) {
        return replyMapper.getReplyByCommentId(askId, commentId);
    }

    @Override
    public Integer likeReply(Integer userId, Integer replyId) {
        return replyMapper.likeReply(userId, replyId);
    }

    @Override
    public Integer cancelLikeReply(Integer userId, Integer replyId) {
        return replyMapper.cancelLikeReply(userId, replyId);
    }

    @Override
    public Integer addReply(Reply reply) {
        return replyMapper.addReply(reply);
    }

    @Override
    public Integer deleteReply(Integer replyId) {
        return replyMapper.deleteReply(replyId);
    }
}
