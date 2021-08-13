package com.IM.springboot_mybatis.controller;

import com.IM.springboot_mybatis.entity.*;
import com.IM.springboot_mybatis.mapper.GoodMapper;
import com.IM.springboot_mybatis.service.AddressService;
import com.IM.springboot_mybatis.service.FeedbackService;
import com.IM.springboot_mybatis.service.GoodService;
import com.IM.springboot_mybatis.service.OrderService;
import com.IM.springboot_mybatis.service.impl.AddressServiceImpl;
import com.IM.springboot_mybatis.utils.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final GoodService goodService;
    private final AddressService addressService;
    private final OrderService orderService;
    private final FeedbackService feedbackService;

    @Autowired
    public ShopController(GoodService goodService, AddressService addressService, OrderService orderService, FeedbackService feedbackService) {
        this.goodService = goodService;
        this.addressService = addressService;
        this.orderService = orderService;
        this.feedbackService = feedbackService;
    }

    @RequestMapping("/homePageContent")
    public JsonResult<Map<String, List<GoodInfo>>> getHomePageContent() {
        JsonResult<Map<String, List<GoodInfo>>> json;
        Map<String, List<GoodInfo>> map = new HashMap<>();
        GoodInfo good1 = goodService.getGoodById(1);
        GoodInfo good2 = goodService.getGoodById(2);
        List<GoodInfo> res = new ArrayList<>();
        res.add(good1);
        res.add(good2);
        map.put("slide", res);
        json = new JsonResult<>(map, "1", "查询成功");
        return json;
    }

    @RequestMapping("/detail")
    public JsonResult<GoodInfo> getGoodInfoByID(int goodId) {
        JsonResult<GoodInfo> json;
        GoodInfo res = goodService.getGoodById(goodId);
        if (res != null) {
            json = new JsonResult<>(res, "1", "查询成功");
        } else json = new JsonResult<>(null, "0", "查询不到该goodId");
        return json;
    }

    @RequestMapping("/category")
    public JsonResult<List<Category>> getCategory() {
        JsonResult<List<Category>> json;
        List<Category> list = goodService.getCategory();
        if (list != null) {
            json = new JsonResult<>(list, "1", "查询成功");
        } else json = new JsonResult<>(null, "0", "查询不到Category");
        return json;
    }

    @RequestMapping("/getCategoryGoods")
    public JsonResult<List<GoodInfo>> getCategoryGoods(int categoryId) {
        JsonResult<List<GoodInfo>> json;
        List<GoodInfo> res = goodService.getGoodsByCategoryId(categoryId);
        if (res != null) {
            json = new JsonResult<>(res, "1", "查询成功");
        } else json = new JsonResult<>(null, "0", "查询不到Category");
        return json;
    }

    @RequestMapping("/getAddress")
    public JsonResult<List<Address>> getAddressById(int userId) {
        JsonResult<List<Address>> json;
        List<Address> res = addressService.getAddressByUserId(userId);
        if (res != null) {
            json = new JsonResult<>(res, "1", "查询成功");
        } else json = new JsonResult<>(null, "0", "查询不到地址信息");
        return json;
    }

    @RequestMapping("/updateAddress")
    public JsonResult<Integer> updateAddress(int addressId, String address) {
        JsonResult<Integer> json;
        int res = addressService.updateAddress(addressId, address);
        if (res == 1) {
            json = new JsonResult<>(1, "1", "地址修改成功");
        } else {
            json = new JsonResult<>(0, "0", "地址修改失败");
        }
        return json;
    }

    @RequestMapping("/createOrder")
    public JsonResult<Integer> createOrder(Order order) {
        JsonResult<Integer> json;
        int res = orderService.createOrder(order);
        if (res == 1) {
            json = new JsonResult<>(1, "1", "地址修改成功");
        } else {
            json = new JsonResult<>(0, "0", "地址修改失败");
        }
        return json;
    }

    @RequestMapping("/getNonPaymentOrder")
    public JsonResult<List<Order>> getNonPaymentOrder(int userId) {
        JsonResult<List<Order>> json;
        List<Order> res = orderService.getNonPaymentOrder(userId);
        if (res != null) {
            json = new JsonResult<>(res, "1", "订单获取成功");
        } else {
            json = new JsonResult<>(null, "0", "订单获取失败");
        }
        return json;
    }

    @RequestMapping("/getWaitingShipmentOrders")
    public JsonResult<List<Order>> getWaitingShipmentOrders(int shopId) {
        JsonResult<List<Order>> json;
        List<Order> res = orderService.getWaitingShipmentOrders(shopId);
        if (res != null) {
            json = new JsonResult<>(res, "1", "订单获取成功");
        } else {
            json = new JsonResult<>(null, "0", "订单获取失败");
        }
        return json;
    }


    @RequestMapping("/getProcessingOrder")
    public JsonResult<List<Order>> getProcessingOrder(int userId) {
        JsonResult<List<Order>> json;
        List<Order> res = orderService.getProcessingOrder(userId);
        if (res != null) {
            json = new JsonResult<>(res, "1", "订单获取成功");
        } else {
            json = new JsonResult<>(null, "0", "订单获取失败");
        }
        return json;
    }

    @RequestMapping("/getShippingOrder")
    public JsonResult<List<Order>> getShippingOrder(int userId) {
        JsonResult<List<Order>> json;
        List<Order> res = orderService.getShippingOrder(userId);
        if (res != null) {
            json = new JsonResult<>(res, "1", "订单获取成功");
        } else {
            json = new JsonResult<>(null, "0", "订单获取失败");
        }
        return json;
    }

    @RequestMapping("/getCommentOrder")
    public JsonResult<List<Order>> getCommentOrder(int userId) {
        JsonResult<List<Order>> json;
        List<Order> res = orderService.getCommentOrder(userId);
        if (res != null) {
            json = new JsonResult<>(res, "1", "订单获取成功");
        } else {
            json = new JsonResult<>(null, "0", "订单获取失败");
        }
        return json;
    }

    @RequestMapping("/deleteOrderById")
    public JsonResult<Integer> deleteOrderById(int orderId) {
        JsonResult<Integer> json;
        Integer res = orderService.deleteOrderById(orderId);
        if (res == 1) {
            json = new JsonResult<>(res, "1", "订单删除成功");
        } else {
            json = new JsonResult<>(res, "0", "订单删除失败");
        }
        return json;
    }

    @RequestMapping("/purchase")
    public JsonResult<Integer> purchase(int orderId, int userId, int addressId) {
        JsonResult<Integer> json;
        double money = orderService.getMoney(userId);
        Order order = orderService.getOrderById(orderId);
        if (order.getPrice() > money) {
            json = new JsonResult<>(0, "0", "购买失败，余额不足");
        } else {
            double remain = money - order.getPrice();
            orderService.updateMoney(userId, remain);
            orderService.updateOrder(1, orderId);
            orderService.setAddress(addressId, orderId);
            json = new JsonResult<>(1, "1", "购买成功");
        }
        return json;
    }


    @RequestMapping("/updateOrder")
    public JsonResult<Integer> processOrder(int orderId, int state) {
        int res = orderService.updateOrder(state, orderId);
        return new JsonResult<>(res, "1", "操作成功");
    }

    @RequestMapping("/getBalance")
    public JsonResult<Double> getBalance(int userId) {
        JsonResult<Double> json;
        double res = orderService.getMoney(userId);
        json = new JsonResult<>(res, "1", "");
        return json;
    }

    @RequestMapping("/addGood")
    public JsonResult<Integer> addGood(GoodInfo goodInfo) {
        JsonResult<Integer> json;
        Integer res = goodService.addGood(goodInfo);
        if (res == 1) {
            json = new JsonResult<>(res, "1", "商品添加成功");
        } else {
            json = new JsonResult<>(res, "0", "商品添加失败");
        }
        return json;
    }

    @RequestMapping("/updateGood")
    public JsonResult<Integer> updateGood(GoodInfo goodInfo) {
        JsonResult<Integer> json;
        Integer res = goodService.updateGood(goodInfo);
        if (res == 1) {
            json = new JsonResult<>(res, "1", "商品信息修改成功");
        } else {
            json = new JsonResult<>(res, "0", "商品信息修改失败");
        }
        return json;
    }

    @RequestMapping("/confirmOrder")
    public JsonResult<Integer> confirmOrder(int orderId) {
        int res = orderService.updateOrder(3, orderId);
        Order order = orderService.getOrderById(orderId);
        double money = orderService.getMoney(order.getUserId());
        money -= order.getPrice();
        orderService.updateMoney(order.getUserId(), money);
        return new JsonResult<>(res, "1", "操作成功");
    }


    @RequestMapping("/getFeedbackByGoodId")
    public JsonResult<List<Feedback>> getFeedbackByGoodId(Integer askId, Integer goodId) {
        //PageHelper.startPage(page, 10);
        List<Feedback> res = feedbackService.getFeedbackByGoodId(askId, goodId);
        //PageInfo<Feedback> pageInfo = new PageInfo<>(res);
        JsonResult<List<Feedback>> json;
        json = !res.isEmpty()
                ? new JsonResult<>(res, "1", "获取到评价"/*,pageInfo.getPages()*/)
                : new JsonResult<>(null, "0", "评价数量为0"/*,pageInfo.getPages()*/);
        return json;
    }

    @RequestMapping("/addFeedback")
    public JsonResult<Integer> addPost(Feedback feedback) {
        JsonResult<Integer> json;
        Integer res = feedbackService.addFeedback(feedback);
        orderService.updateOrder(4, feedback.getOrderId());
        json = new JsonResult<>(res, "1", "发布订单评价成功");
        return json;
    }

    @RequestMapping("/getShop")
    public JsonResult<Shop> getShop(Integer userId) {
        JsonResult<Shop> json;
        Shop res = goodService.getShop(userId);
        json = new JsonResult<>(res, "1", "查询成功");
        return json;
    }

    @RequestMapping("/getShopList")
    public JsonResult<List<GoodInfo>> getShopList(Integer shopId) {
        JsonResult<List<GoodInfo>> json;
        List<GoodInfo> res = goodService.getShopList(shopId);
        json = new JsonResult<>(res, "1", "查询成功");
        return json;
    }

    @RequestMapping("/updateAmount")
    public JsonResult<Integer> updateAmount(Integer amount, Integer goodId) {
        JsonResult<Integer> json;
        Integer res = goodService.updateAmount(amount, goodId);
        json = new JsonResult<>(res, "1", "查询成功");
        return json;
    }
}
