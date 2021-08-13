package com.IM.springboot_mybatis.mapper;

import com.IM.springboot_mybatis.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {
    @Select("select * from address where userId = #{userId}")
    List<Address> getAddressByUserId(@Param("userId") int userId);

    @Update("update address set address = #{address} where addressId = #{addressId}")
    int updateAddress(@Param("addressId") int addressId,@Param("address") String address);
}
