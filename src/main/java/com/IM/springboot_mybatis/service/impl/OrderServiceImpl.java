package com.IM.springboot_mybatis.service.impl;

import com.IM.springboot_mybatis.entity.Order;
import com.IM.springboot_mybatis.mapper.OrderMapper;
import com.IM.springboot_mybatis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderMapper.getOrderById(orderId);
    }

    @Override
    public Integer createOrder(Order order) {
        return orderMapper.createOrder(order);
    }

    @Override
    public List<Order> getNonPaymentOrder(int userId) {
        return orderMapper.getNonPaymentOrder(userId);
    }

    @Override
    public Integer deleteOrderById(int orderId) {
        return orderMapper.deleteOrderById(orderId);
    }

    @Override
    public double getMoney(int userId) {
        return orderMapper.getMoney(userId);
    }

    @Override
    public Integer updateMoney(int userId, double money) {
        return orderMapper.updateMoney(userId,money);
    }

    @Override
    public Integer updateOrder(int state, int orderId) {
        return orderMapper.updateOrder(state,orderId);
    }

    @Override
    public Integer setAddress(int addressId, int orderId) {
        return orderMapper.setAddress(addressId,orderId);
    }

    @Override
    public List<Order> getProcessingOrder(int userId) {
        return orderMapper.getProcessingOrder(userId);
    }

    @Override
    public List<Order> getShippingOrder(int userId) {
        return orderMapper.getShippingOrder(userId);
    }

    @Override
    public List<Order> getCommentOrder(int userId) {
        return orderMapper.getCommentOrder(userId);
    }

    @Override
    public List<Order> getWaitingShipmentOrders(int shopId) {
        return orderMapper.getWaitingShipmentOrders(shopId);
    }
}
