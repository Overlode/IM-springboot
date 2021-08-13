package com.IM.springboot_mybatis.service;

import com.IM.springboot_mybatis.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getFeedbackByGoodId(Integer askId, Integer goodId);
    Integer addFeedback(Feedback feedback);
}
