package com.medicine.Mapper;

import com.medicine.Entity.Category;

public interface categoryMapper {
    boolean insert(Category m);
    boolean delete(Category m);
    boolean update(Category m);
    Category[] select(String key);
}
