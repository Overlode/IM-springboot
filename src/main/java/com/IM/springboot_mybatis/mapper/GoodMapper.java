package com.IM.springboot_mybatis.mapper;

import com.IM.springboot_mybatis.entity.Category;
import com.IM.springboot_mybatis.entity.GoodInfo;
import com.IM.springboot_mybatis.entity.Shop;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodMapper {
    @Select("select * from goodinfo WHERE goodId  = #{goodId}")
    GoodInfo findGoodById(@Param("goodId") Integer goodId);

    @Select("select * from category")
    List<Category> getCategory();

    @Select("SELECT * FROM goodinfo where categoryId = #{categoryId}")
    List<GoodInfo> getGoodsByCategoryId(@Param("categoryId") Integer categoryId);

    @Insert({"insert into goodinfo(amount,price,goodName,goodDetail,shopId,image1,image2,image3,image4,categoryId) values(#{amount},#{price},#{goodName},#{goodDetail},#{shopId},#{image1},#{image2},#{image3},#{image4},#{categoryId})"})
    Integer addGood(GoodInfo goodInfo);

    @Update("update im_database.goodinfo set amount=#{amount},price=#{price},goodName=#{goodName},goodDetail=#{goodDetail},shopId=#{shopId},image1=#{image1},image2=#{image2},image3=#{image3},image4=#{image4},categoryId=#{categoryId} where goodId=#{goodId}")
    Integer updateGood(GoodInfo goodInfo);

    @Select("SELECT * FROM shop where userId = #{userId}")
    Shop getShop(Integer userId);

    @Select("SELECT goodinfo.* from goodinfo where shopId=#{shopId}")
    List<GoodInfo> getShopList(Integer shopId);

    @Update("update im_database.goodinfo set amount = #{amount} where goodId = #{goodId}")
    Integer updateAmount(Integer amount,Integer goodId);
}
