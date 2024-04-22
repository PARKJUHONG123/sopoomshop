package com.ddingcode.sopoomshop.service;

import com.ddingcode.sopoomshop.domain.Item;
import com.ddingcode.sopoomshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Item save(Item item) {
        itemRepository.save(item);

        return itemRepository.findById(item.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("save error"));
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }


}
