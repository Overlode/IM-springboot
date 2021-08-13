package com.IM.springboot_mybatis.service.impl;

import com.IM.springboot_mybatis.entity.Category;
import com.IM.springboot_mybatis.entity.GoodInfo;
import com.IM.springboot_mybatis.entity.Shop;
import com.IM.springboot_mybatis.mapper.GoodMapper;
import com.IM.springboot_mybatis.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodService")
public class GoodServiceImpl implements GoodService {
    private final GoodMapper goodMapper;

    @Autowired
    public GoodServiceImpl(GoodMapper goodMapper) {
        this.goodMapper = goodMapper;
    }

    @Override
    public GoodInfo getGoodById(int goodId) {
        return goodMapper.findGoodById(goodId);
    }

    @Override
    public List<Category> getCategory() {
        return goodMapper.getCategory();
    }

    @Override
    public List<GoodInfo> getGoodsByCategoryId(int categoryId) {
        return goodMapper.getGoodsByCategoryId(categoryId);
    }

    @Override
    public Integer addGood(GoodInfo goodInfo) {
        return goodMapper.addGood(goodInfo);
    }

    @Override
    public Integer updateGood(GoodInfo goodInfo) {
        return goodMapper.updateGood(goodInfo);
    }

    @Override
    public Shop getShop(Integer userId) {
        return goodMapper.getShop(userId);
    }

    @Override
    public List<GoodInfo> getShopList(Integer shopId) {
        return goodMapper.getShopList(shopId);
    }

    @Override
    public Integer updateAmount(Integer amount, Integer goodId) {
        return goodMapper.updateAmount(amount,goodId);
    }
}
