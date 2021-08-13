package com.IM.springboot_mybatis.service;

import com.IM.springboot_mybatis.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAddressByUserId(int userId);
    public int updateAddress(int addressId,String address);
}
