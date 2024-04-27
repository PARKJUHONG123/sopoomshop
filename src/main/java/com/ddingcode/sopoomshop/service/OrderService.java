package com.ddingcode.sopoomshop.service;

import com.ddingcode.sopoomshop.domain.Order;
import com.ddingcode.sopoomshop.domain.dto.OrderResultDto;
import com.ddingcode.sopoomshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Order save(Order order) {
        orderRepository.save(order);

        return orderRepository.findById(order.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("save error"));
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public List<OrderResultDto> findAll() {
        return orderRepository.findAll();
    }


}
