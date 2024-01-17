package com.medicine.Mapper.imp;

import com.medicine.Entity.Category;

public interface categoryImp {
    boolean insert(Category m);
    boolean delete(Category m);
    boolean update(Category m);
    Category[] select(String key);
}
