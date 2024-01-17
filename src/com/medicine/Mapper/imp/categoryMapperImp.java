package com.medicine.Mapper.imp;

import com.medicine.Entity.Category;
import com.medicine.Mapper.categoryMapper;
import com.medicine.Util.JDBCHelper;

import java.util.List;

public class categoryMapperImp implements categoryMapper {
    private static final JDBCHelper jdbc = new JDBCHelper();

    @Override
    public boolean insert(Category c) {
        String sql = "INSERT INTO category(name, description) VALUES(?,?)";
        String[] values = new String[]{c.getName(), c.getDescription()};
        return jdbc.insert(sql, values) > 0;
    }

    @Override
    public boolean delete(Category c) {
        String sql = "DELETE FROM category WHERE id=?";
        String[] values = new String[]{String.valueOf(c.getId())};
        return jdbc.delete(sql, values) > 0;
    }

    @Override
    public boolean update(Category c) {
        String sql = "UPDATE category SET name=?, description=? WHERE id=?";
        String[] values = new String[]{c.getName(), c.getDescription(), String.valueOf(c.getId())};
        return jdbc.update(sql, values) > 0;
    }

    @Override
    public List<Category> select(Category c) {
        String sql = "SELECT * FROM category where id=?";
        String[] values = new String[]{String.valueOf(c.getId())};
        return jdbc.select(sql, values, Category.class);
    }
}
