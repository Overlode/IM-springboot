package com.IM.springboot_mybatis.mapper;

import com.IM.springboot_mybatis.entity.Updates;
import com.IM.springboot_mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    //根据id查找用户信息##############
    @Select("select * ,#{askId} as askId from user WHERE userId  = #{userId}")
    @Results(id = "userMap",value = {
            @Result(id = true,property = "userId",column = "userId"),
            @Result(property = "postCount",column = "userId",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.UserMapper.getPostCountById")),
            @Result(property = "fanCount",column = "userId",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.UserMapper.getFanNumById")),
            @Result(property = "followCount",column = "userId",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.UserMapper.getFollowNumById")),
            @Result(property = "isFollow",column = "{askId = askId,userId = user.userId}",
                    one = @One(select = "com.IM.springboot_mybatis.mapper.UserMapper.isFollow")),
    })
    User findUserById(@Param("askId") Integer askId, @Param("userId") Integer userId);
    @Select("select * ,#{askId} as askId from user WHERE username  = #{username} ")
    @ResultMap("userMap")
    User findUserByName(@Param("askId") Integer askId, String username);

    //添加用户或者说是注册操作
    @Insert({"insert into user(email,password) values(#{email},#{password})"})
    @Options(useGeneratedKeys=true,keyColumn="userId",keyProperty = "userId")
    Integer insertUser(User user);

    //登录操作，查询出结果就登录成功，查询结果空就失败
    @Select("SELECT USER.*,p.postCount,follow.followCount,fan.fanCount FROM " +
            "USER LEFT JOIN (SELECT userId ,count(*) AS postCount from post where userId = (select userId from user where email =  #{email})) as p ON USER.userId = p.userId " +
            "LEFT JOIN (SELECT fanId, count(*) AS followCount FROM fans WHERE fanId = (select userId from user where email = #{email} ) ) AS follow ON USER.userId = follow.fanId " +
            "LEFT JOIN (SELECT followedId, count(*) AS fanCount FROM fans WHERE followedId = (select userId from user where email = #{email} ) ) AS fan ON USER.userId = fan.followedId " +
            "WHERE email = #{email} and password = #{password}")
    User logIn(User user);

    //更新密码操作，更新成功返回1，否则返回0
    @Update("update user set password=#{password} where email=#{email}")
    int updatePwd(String email,String password);

    //更新用户信息操作，更新成功返回1，否则返回0
    @Update("update user set username=#{username},bio=#{bio},profileImg=#{profileImg} where email=#{email}")
    int updateUserDetail(User user);

    //查找用户关注的人
    @Select("select * ,#{userId}  as askId from user WHERE userId IN (SELECT followedId FROM fans WHERE fanId= #{userId})")
    @ResultMap("userMap")
    List<User> findFollow(Integer userId);

    //查找关注用户的人即粉丝
    @Select("select *,#{userId} as askId from user WHERE user.userId IN (SELECT fanId from fans WHERE followedId= #{userId})")
    @ResultMap("userMap")
    List<User> findFans(Integer userId);

    @Select("select *,#{askId} as askId from user WHERE user.userId IN (SELECT userId from postliked WHERE postId= #{postId})")
    @ResultMap("userMap")
    List<User> getLikedUser(Integer askId,Integer postId);
    @Select("SELECT *,#{askId} as askId from user where username like '%${key}%'")
    @ResultMap("userMap")
    List<User> searchUser(Integer askId,String key);
    //关注一个用户，提供关注者与被关注者
    @Insert("insert into fans (fanId,followedId) values(#{fanId},#{followedId})")
    int followAUser(Integer fanId, Integer followedId);
    //取关一个用户，提供关注者与被关注者
    @Delete("DELETE FROM fans WHERE fanId = #{fanId} and followedId = #{followedId}")
    int cancelFollowAUser(Integer fanId,Integer followedId);

    //通用修改个人信息
    @Update("update user set ${property} = #{value} where userId=#{userId}")
    Integer updateUserProperty(Integer userId, String property, String value);

    //查询用户名是否已存在
    @Select("select count(*) from user where username = #{username}")
    Integer isUsernameExist(String username);

    //根据userId查询动态数量
    @Select("select count(*) from post where userId = #{userId}")
    Integer getPostCountById(Integer userId);
    //根据userId查询粉丝数量
    @Select("select count(*) from fans where followedId = #{userId}")
    Integer getFanNumById(Integer userId);
    //根据userId查询关注数量
    @Select("select count(*) from fans where fanId = #{userId}")
    Integer getFollowNumById(Integer userId);

    @Select("SELECT count(*) from fans where fanId = #{askId} and followedId = #{userId}")
    Integer isFollow(Integer askId, Integer userId);

    @Select("SELECT count(*) from fans where followedId = #{askId} and fanId = #{userId}")
    Integer isAFan(Integer askId, Integer userId);
    @Select("SELECT count(*) from user where email = #{email}")
    Integer isExistTheEmail(String email);

    @Select("select username from user where userId=#{userId}")
    String getUsernameById(Integer userId);
    @Select("select profileImg from user where userId=#{userId}")
    String getProfileImgById(Integer userId);

    @Update("update location set latitude = #{latitude},longitude = #{longitude} where userId = #{userId}")
    int updatePosition(int userId,double latitude,double longitude);

    @Select("SELECT im_database.user.*,im_database.location.latitude,im_database.location.longitude FROM im_database.location,im_database.user where location.userId=user.userId and location.userId!=#{userId}")
    List<User> getUserLocation(@Param("userId") int userId);
}
