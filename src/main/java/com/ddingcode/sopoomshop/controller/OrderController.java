package com.ddingcode.sopoomshop.controller;

import com.ddingcode.sopoomshop.controller.form.OrderForm;
import com.ddingcode.sopoomshop.domain.Member;
import com.ddingcode.sopoomshop.domain.Order;
import com.ddingcode.sopoomshop.service.ItemService;
import com.ddingcode.sopoomshop.service.MemberService;
import com.ddingcode.sopoomshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/orders/new")
    public String createForm(Model model) {
        model.addAttribute("form", new OrderForm());
        model.addAttribute("members", JsonTransform.getJsonString(memberService.findAll()));
        model.addAttribute("items", JsonTransform.getJsonString(itemService.findAll()));
        return "orders/createOrderForm";
    }

    @PostMapping("/orders/create-order")
    public String create(OrderForm orderForm) {

        Order order = Order.createItem(orderForm.getItemId(),
                orderForm.getMemberId(),
                orderForm.getQuantity());
        orderService.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String list(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", JsonTransform.getJsonString(orders));
        return "orders/orderList";
    }

}
