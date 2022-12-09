package com.cydeo.impl;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    public final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> getListOfAddress() {
        return addressRepository.findAll().stream().map(address -> mapperUtil.convert(address,new AddressDTO())).collect(Collectors.toList());
    }
}
