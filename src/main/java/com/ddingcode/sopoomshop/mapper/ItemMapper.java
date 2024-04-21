package com.ddingcode.sopoomshop.mapper;

import com.ddingcode.sopoomshop.domain.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);
    Optional<Item> findById(Long id);
    List<Item> findAll();

}
