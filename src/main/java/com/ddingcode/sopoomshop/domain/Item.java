package com.ddingcode.sopoomshop.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    private Long id;
    private String name;
    private int buyPrice;
    private int salePrice;
    private int stock;

    public static Item createItem(String name, int buyPrice, int salePrice, int stock) {
        Item item = new Item();
        item.setName(name);
        item.setBuyPrice(buyPrice);
        item.setSalePrice(salePrice);
        item.setStock(stock);
        return item;
    }

}
