package com.medicine.Mapper;
import com.medicine.Entity.Category;
import com.medicine.Entity.Medicine;
import com.medicine.Query.MedicineQuery;

import java.util.List;

public interface medicineMapper {
    boolean insert(Medicine m);
    boolean delete(Medicine m);
    boolean update(Medicine m);
//    List<Medicine> select(Medicine m);

    List<Medicine> selectByMedicineName(Medicine m);

    List<Medicine> selectAll();
    List<Medicine> fuzzySelect(String key);

    List<Medicine> selectByMedicinePrice(MedicineQuery m);

    List<Medicine> selectByMedicinetype(MedicineQuery m);

    List<Medicine> selectByMedicineDate(MedicineQuery m);

}
