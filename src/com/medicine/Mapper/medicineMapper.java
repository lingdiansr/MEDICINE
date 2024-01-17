package com.medicine.Mapper;
import com.medicine.Entity.Medicine;
public interface medicineMapper {
    boolean insert(Medicine m);
    boolean delete(Medicine m);
    boolean update(Medicine m);
    Medicine[] select(String key);
}
