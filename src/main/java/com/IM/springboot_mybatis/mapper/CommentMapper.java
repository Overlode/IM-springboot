package com.IM.springboot_mybatis.mapper;

import com.IM.springboot_mybatis.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    //根据postId查询其所有的评论
    @Select("SELECT * ,#{askId} as askId FROM comments WHERE postId = #{postId} order by commentId DESC")
    @Results(id = "commentMap",value = {
            @Result(id = true,property = "commentId",column = "commentId"),
            @Result(property = "userId",column = "userId"),
            @Result(property = "profileImg",column = "userId",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.UserMapper.getProfileImgById")),
            @Result(property = "username",column = "userId",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.UserMapper.getUsernameById")),
            @Result(property = "likeCount",column = "commentId",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.CommentMapper.getCommentLikeCount")),
            @Result(property = "isLiked",column = "{askId = askId,commentId = commentId}",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.CommentMapper.isLiked")),
            @Result(property = "replyCount",column = "commentId",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.CommentMapper.getReplyCountByCommentId")),
            @Result(property="replyList",column = "{askId = askId,commentId = commentId}",
                    many = @Many(select = "com.IM.springboot_mybatis.mapper.ReplyMapper.getTopReplyByCommentId"))
    })
    List<Comment> getCommentByPostId(Integer askId,Integer postId);

    //根据commentId查评论的点赞数
    @Select("select count(*) from commentliked where commentId = #{commentId}")
    Integer getCommentLikeCount(Integer commentId);
    //给评论点赞
    @Insert("insert into commentliked (userId,commentId) values(#{userId},#{commentId})")
    Integer likeComment(Integer userId ,Integer commentId);
    //取消评论点赞
    @Delete("DELETE FROM commentliked WHERE userId = #{userId} and commentId = #{commentId}")
    Integer cancelLikeComment(Integer userId ,Integer commentId);
    //是否给评论点赞了
    @Select("select count(*) from commentliked where userId = #{askId} and commentId = #{commentId}")
    Integer isLiked(Integer askId,Integer commentId);
    //添加评论
    @Insert("insert into comments (userId,postId,image,comment,date) " +
            "values(#{userId},#{postId},#{image},#{comment},#{date}) ")
    Integer addComment(Comment comment);
    //删除评论
    @Delete("delete from comments where commentId = #{commentId}")
    Integer deleteCommentByCommentId(Integer commentId);
    @Select("select count(*) as replyCount from reply where commentId = #{commentId}")
    Integer getReplyCountByCommentId(Integer commentId);
}
