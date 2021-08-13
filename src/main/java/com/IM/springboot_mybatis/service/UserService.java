package com.IM.springboot_mybatis.service;

import com.IM.springboot_mybatis.entity.Updates;
import com.IM.springboot_mybatis.entity.User;

import java.util.List;

public interface UserService {

    //根据id查找用户
    User findUserById(Integer askId,Integer userId);
    User findUserByName(Integer askId, String username);
    //用户注册，添加成功返回1，否则会抛出异常（使用trycatch捕获异常返回 0 -2019年10月19日10:24:37）
    Integer insertUser(User user);
    //用户登录，
    User logIn(User user);
    //更新密码，更新成功返回1，否则返回0
    int updatePwd(String email,String password);
    //用户更改信息
    int updateUserDetail(User user);
    //查找用户关注的人，参数的email对应 fans
    List<User> findFollow(Integer userId);
    //查找用户的粉丝
    List<User> findFan(Integer userId);
    //fanId关注followedId
    int followAUser(Integer fanId,Integer followedId);
    //fanId取关followedId
    int cancelFollowAUser(Integer fanId,Integer followedId);
    //修改用户个人信息
    Integer updateUserProperty(Integer userId,String property,String value);
    //该用户名是否已存在
    Integer isUsernameExist(String username);
    //邮箱是否使用
    Integer isExistTheEmail(String email);
    //点赞了某个post的人
    List<User> getLikedUser(Integer askId,Integer postId);
    List<User> searchUser(Integer askId,String key);
    int updatePosition(Integer userId,double latitude, double longitude);

    List<User> getNearUser(int userId);
}
