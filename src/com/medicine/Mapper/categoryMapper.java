package com.medicine.Mapper;

import com.medicine.Entity.Category;

import java.util.List;

public interface categoryMapper {
    boolean insert(Category c);
    boolean delete(Category c);
    boolean update(Category c);
   List<Category> select(Category c);
}
