package com.IM.springboot_mybatis.mapper;

import com.IM.springboot_mybatis.entity.Feedback;
import com.IM.springboot_mybatis.entity.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackMapper {
    @Select("SELECT * ,#{askId} as askId FROM feedback WHERE goodId = #{goodId} order by feedbackId DESC")
    @Results(id = "feedbackMap",value = {
            @Result(id = true,property = "feedbackId",column = "feedbackId"),
            @Result(property = "userId",column = "userId"),
            @Result(property = "profileImg",column = "userId",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.UserMapper.getProfileImgById")),
            @Result(property = "username",column = "userId",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.UserMapper.getUsernameById")),
    })
    List<Feedback> getFeedbackByGoodId(Integer askId, Integer goodId);

    @Insert("insert into feedback (userId,date,feedback,image,forwardId,goodId) values(#{userId},#{date},#{feedback},#{image},#{forwardId},#{goodId}) ")
    Integer addFeedback(Feedback feedback);
}
