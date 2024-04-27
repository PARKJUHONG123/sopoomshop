package com.ddingcode.sopoomshop.repository;

import com.ddingcode.sopoomshop.domain.Order;
import com.ddingcode.sopoomshop.domain.dto.OrderResultDto;
import com.ddingcode.sopoomshop.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class OrderRepository {

    private final OrderMapper orderMapper;

    public Order save(Order order) {
        orderMapper.save(order);
        return order;
    }

    public Optional<Order> findById(Long id) {
        return orderMapper.findById(id);
    }

    public List<OrderResultDto> findAll() {
        return orderMapper.findAll();
    }

}
