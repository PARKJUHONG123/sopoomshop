package com.ddingcode.sopoomshop.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    private Long orderId;
    private Long memberId;
    private Long itemId;
    private int quantity;

    public static Order createItem(Long memberId, Long itemId, int quantity) {
        Order order = new Order();
        order.setMemberId(memberId);
        order.setItemId(itemId);
        order.setQuantity(quantity);
        return order;
    }
}
