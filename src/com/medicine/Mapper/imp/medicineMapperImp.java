package com.medicine.Mapper.imp;

import com.medicine.Entity.Medicine;
import com.medicine.Mapper.medicineMapper;
import com.medicine.Util.JDBCHelper;

import java.util.List;

public class medicineMapperImp implements medicineMapper {
    private static final JDBCHelper jdbc = new JDBCHelper();

    @Override
    public boolean insert(Medicine m) {
        String sql = "INSERT INTO medicine(medicineNo,name,factoryAddress,description,price,expire,unit,number,categoryId,deleted) VALUES(?,?,?,?,?,?,?,?,?,?)";
        String[] values = new String[]{
                m.getMedicineNo(),
                m.getMname(),
                m.getMfactoryAddress(),
                m.getMdescription(),
                String.valueOf(m.getMprice()),
                String.valueOf(m.getMexpire()),
                m.getMunit(),
                String.valueOf(m.getMnumber()),
                String.valueOf(m.getMcategoryld()),
                String.valueOf(m.getMdeleted())
        };
        return jdbc.insert(sql, values) > 0;
    }
    @Override
    public boolean delete(Medicine m) {
        String sql = "DELETE FROM medicine WHERE medicineNo=?";
        String[] values = new String[]{m.getMedicineNo()};
        return jdbc.delete(sql, values) > 0;
    }

    @Override
    public boolean update(Medicine m) {
        String sql = "UPDATE medicine SET name=?, factoryAddress=?, description=?, price=?, expire=?, unit=?, number=?, categoryId=?, deleted=? WHERE medicineNo=?";
        String[] values = new String[]{
                m.getMname(),
                m.getMfactoryAddress(),
                m.getMdescription(),
                String.valueOf(m.getMprice()),
                String.valueOf(m.getMexpire()),
                m.getMunit(),
                String.valueOf(m.getMnumber()),
                String.valueOf(m.getMcategoryld()),
                String.valueOf(m.getMdeleted()),
                m.getMedicineNo()
        };
        return jdbc.update(sql, values) > 0;
    }

    @Override
    public List<Medicine> select(Medicine m) {
        String sql = "SELECT * FROM medicine where medicineNo=?";
        String[] values = new String[]{m.getMedicineNo()};
        return jdbc.select(sql, values, Medicine.class);
    }
}
