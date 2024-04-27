package com.ddingcode.sopoomshop.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResultDto {

    private String memberName;
    private String itemName;
    private int salePrice;
    private int quantity;
    private int total;

}
