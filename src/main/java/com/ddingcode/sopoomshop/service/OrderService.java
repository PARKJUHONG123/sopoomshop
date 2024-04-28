package com.ddingcode.sopoomshop.service;

import com.ddingcode.sopoomshop.domain.Order;
import com.ddingcode.sopoomshop.domain.dto.OrderResultDto;
import com.ddingcode.sopoomshop.repository.ItemRepository;
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
    private final ItemRepository itemRepository;

    @Transactional
    public Order save(Order order) {
        int updateCnt = itemRepository.updateStockByOrder(order); // 재고 변경 추가
        if (updateCnt > 0) {
            orderRepository.save(order);
        }

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
