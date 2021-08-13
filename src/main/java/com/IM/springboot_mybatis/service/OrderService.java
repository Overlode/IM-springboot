package com.IM.springboot_mybatis.service;

import com.IM.springboot_mybatis.entity.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(int orderId);
    Integer createOrder(Order order);
    List<Order> getNonPaymentOrder(int userId);
    List<Order> getProcessingOrder(int userId);
    List<Order> getShippingOrder(int userId);
    List<Order> getCommentOrder(int userId);
    List<Order> getWaitingShipmentOrders(int shopId);
    Integer deleteOrderById(int orderId);
    double getMoney(int userId);
    Integer updateMoney(int userId,double money);
    Integer updateOrder(int state,int orderId);
    Integer setAddress(int addressId,int orderId);
}
