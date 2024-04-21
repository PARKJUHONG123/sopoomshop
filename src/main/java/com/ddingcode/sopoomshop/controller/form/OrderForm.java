package com.ddingcode.sopoomshop.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderForm {

    private Long memberId;
    private Long itemId;
    private Integer quantity;

}
