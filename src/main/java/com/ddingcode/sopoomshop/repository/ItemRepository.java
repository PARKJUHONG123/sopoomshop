package com.ddingcode.sopoomshop.repository;

import com.ddingcode.sopoomshop.domain.Item;
import com.ddingcode.sopoomshop.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ItemRepository {

    private final ItemMapper itemMapper;

    public Item save(Item item) {
        itemMapper.save(item);
        return item;
    }

    public Optional<Item> findById(Long id) {
        return itemMapper.findById(id);
    }

    public List<Item> findAll() {
        return itemMapper.findAll();
    }

}
