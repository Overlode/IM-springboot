package com.IM.springboot_mybatis.service;

import com.IM.springboot_mybatis.entity.Category;
import com.IM.springboot_mybatis.entity.GoodInfo;
import com.IM.springboot_mybatis.entity.Shop;

import java.util.List;

public interface GoodService {
    GoodInfo getGoodById(int goodId);
    List<Category> getCategory();
    List<GoodInfo> getGoodsByCategoryId(int categoryId);
    Integer addGood(GoodInfo goodInfo);
    Integer updateGood(GoodInfo goodInfo);
    Shop getShop(Integer userId);
    List<GoodInfo> getShopList(Integer shopId);
    Integer updateAmount(Integer amount,Integer goodId);
}
