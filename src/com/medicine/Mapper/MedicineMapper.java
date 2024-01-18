package com.medicine.Mapper;
import com.medicine.Entity.Medicine;
import com.medicine.Query.MedicineQuery;

import java.util.List;

public interface MedicineMapper {
    boolean insert(Medicine m);
    boolean delete(Medicine m);
    boolean update(Medicine m);

    List<Medicine> selectAll();
    List<Medicine> fuzzySelect(String key);

    String getSqlMedicineQuery(MedicineQuery medicineQuery);

    List<Medicine> search(MedicineQuery medicineQuery);
}
