package com.IM.springboot_mybatis.mapper;

import com.IM.springboot_mybatis.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    @Select("select * from im_database.order WHERE orderId  = #{orderId}")
    Order getOrderById(@Param("orderId") Integer orderId);


    //"insert into user(email,password) values(#{email},#{password})"
    @Insert("insert into im_database.order(goodId,amount,price,userId,state) value(#{order.goodId},#{order.amount},#{order.price},#{order.userId},#{order.state})")
    Integer createOrder(@Param("order") Order order);

    @Select("SELECT im_database.order.orderId,im_database.order.goodId,im_database.order.amount,im_database.order.price,im_database.order.userId,im_database.order.state,im_database.goodinfo.goodName,im_database.goodinfo.image1 " +
            "from im_database.order,im_database.goodinfo " +
            "where im_database.order.goodId=im_database.goodinfo.goodId and im_database.order.userId=#{userId} and state=0;")
    List<Order> getNonPaymentOrder(@Param("userId") int userId);

    @Select("SELECT im_database.order.orderId,im_database.order.goodId,im_database.order.amount,im_database.order.price,im_database.order.userId,im_database.order.state,im_database.goodinfo.goodName,im_database.goodinfo.image1 " +
            "from im_database.order,im_database.goodinfo " +
            "where im_database.order.goodId=im_database.goodinfo.goodId and im_database.order.userId=#{userId} and state=1;")
    List<Order> getProcessingOrder(@Param("userId") int userId);

    @Select("SELECT im_database.order.orderId,im_database.order.goodId,im_database.order.amount,im_database.order.price,im_database.order.userId,im_database.order.state,im_database.goodinfo.goodName,im_database.goodinfo.image1 " +
            "from im_database.order,im_database.goodinfo " +
            "where im_database.order.goodId=im_database.goodinfo.goodId and im_database.order.userId=#{userId} and state=2;")
    List<Order> getShippingOrder(@Param("userId") int userId);

    @Select("SELECT im_database.order.orderId,im_database.order.goodId,im_database.order.amount,im_database.order.price,im_database.order.userId,im_database.order.state,im_database.goodinfo.goodName,im_database.goodinfo.image1 " +
            "from im_database.order,im_database.goodinfo " +
            "where im_database.order.goodId=im_database.goodinfo.goodId and im_database.order.userId=#{userId} and state=3;")
    List<Order> getCommentOrder(@Param("userId") int userId);

    @Select("select im_database.user.username,im_database.order.*,im_database.shop.shopId,im_database.goodinfo.goodName,im_database.goodinfo.image1,im_database.address.address from im_database.order,im_database.user,im_database.shop,im_database.goodinfo,im_database.address where im_database.order.state=1 and im_database.goodinfo.shopId=im_database.shop.shopId and im_database.order.goodId=im_database.goodinfo.goodId and im_database.shop.shopId=#{shopId} and im_database.order.addressId=im_database.address.addressId and im_database.user.userId=im_database.order.userId")
    List<Order> getWaitingShipmentOrders(int shopId);

    @Delete("delete from im_database.order where orderId = #{orderId}")
    Integer deleteOrderById(@Param("orderId")int orderId);

    @Select("select money from user where userId = #{userId}")
    double getMoney(int userId);

    @Update("update im_database.user set money = #{money} where userId = #{userId}")
    Integer updateMoney(@Param("userId") int userId,@Param("money")double money);

    @Update("update im_database.order set state = #{state} where orderId = #{orderId}")
    Integer updateOrder(int state,int orderId);

    @Update("update im_database.order set addressId = #{addressId} where orderId = #{orderId}")
    Integer setAddress(int addressId,int orderId);


}
