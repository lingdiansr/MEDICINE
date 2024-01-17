package com.medicine.Mapper.imp;
import com.medicine.Entity.Medicine;
public interface medicineImp {
    boolean insert(Medicine m);
    boolean delete(Medicine m);
    boolean update(Medicine m);
    Medicine[] select(String key);
}
