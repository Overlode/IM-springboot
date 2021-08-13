package com.IM.springboot_mybatis.service.impl;

import com.IM.springboot_mybatis.entity.Feedback;
import com.IM.springboot_mybatis.mapper.FeedbackMapper;
import com.IM.springboot_mybatis.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackMapper feedbackMapper;

    @Autowired
    public FeedbackServiceImpl(FeedbackMapper feedbackMapper) {
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public List<Feedback> getFeedbackByGoodId(Integer askId, Integer goodId) {
        return feedbackMapper.getFeedbackByGoodId(askId, goodId);
    }

    @Override
    public Integer addFeedback(Feedback feedback) {
        return feedbackMapper.addFeedback(feedback);
    }


}
