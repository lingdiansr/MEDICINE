package com.medicine.Mapper;
import com.medicine.Entity.Medicine;

import java.util.List;

public interface medicineMapper {
    boolean insert(Medicine m);
    boolean delete(Medicine m);
    boolean update(Medicine m);
    List<Medicine> select(Medicine m);
    List<Medicine> selectAll();
    List<Medicine> fuzzySelect(String key);
}
