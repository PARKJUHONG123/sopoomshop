package com.ddingcode.sopoomshop.mapper;

import com.ddingcode.sopoomshop.domain.Order;
import com.ddingcode.sopoomshop.domain.dto.OrderResultDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderMapper {

    void save(Order order);
    Optional<Order> findById(Long id);
    List<OrderResultDto> findAll();
}
