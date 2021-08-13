package com.IM.springboot_mybatis.service.impl;

import com.IM.springboot_mybatis.entity.Address;
import com.IM.springboot_mybatis.mapper.AddressMapper;
import com.IM.springboot_mybatis.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {

    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressMapper addressMapper){this.addressMapper=addressMapper;}

    @Override
    public List<Address> getAddressByUserId(int userId) {
        return addressMapper.getAddressByUserId(userId);
    }

    @Override
    public int updateAddress(int addressId, String address) {
        return addressMapper.updateAddress(addressId,address);
    }
}
