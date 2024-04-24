package com.ddingcode.sopoomshop.controller;

import com.ddingcode.sopoomshop.controller.form.ItemForm;
import com.ddingcode.sopoomshop.domain.Item;
import com.ddingcode.sopoomshop.service.ItemService;
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
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new ItemForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/create-item")
    public String create(ItemForm itemForm) {

        Item item = Item.createItem(itemForm.getName(),
                itemForm.getBuyPrice(),
                itemForm.getSalePrice(),
                itemForm.getStock());

        itemService.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", JsonTransform.getJsonString(items));
        return "items/itemList";
    }

}
