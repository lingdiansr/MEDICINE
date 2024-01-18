package com.medicine.Mapper;

import com.medicine.Entity.Category;

import java.util.List;

public interface CategoryMapper {
    boolean insert(Category c);

    boolean delete(Category c);

    boolean update(Category c);

    List<Category> select(Category c);

    List<Category> selectAll();
    List<Category> selectIdByName(String name);
}
