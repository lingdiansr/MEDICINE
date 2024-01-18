package com.medicine.Mapper;
import com.medicine.Entity.Medicine;
import com.medicine.Query.MedicineQuery;

import java.util.List;

public interface medicineMapper {
    boolean insert(Medicine m);
    boolean delete(Medicine m);
    boolean update(Medicine m);

    List<Medicine> selectAll();
    List<Medicine> fuzzySelect(String key);

    String getSQLFromMedicineQuery(MedicineQuery query);
    public List<Medicine> search(MedicineQuery query);
}
