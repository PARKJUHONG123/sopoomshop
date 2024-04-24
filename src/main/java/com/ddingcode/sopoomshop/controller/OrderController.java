package com.ddingcode.sopoomshop.controller;

import com.ddingcode.sopoomshop.controller.form.OrderForm;
import com.ddingcode.sopoomshop.domain.Order;
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

    @GetMapping("/orders/new")
    public String createForm(Model model) {
        model.addAttribute("form", new OrderForm());
        return "members/createOrderForm";
    }

    @PostMapping("/orders/create-member")
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
