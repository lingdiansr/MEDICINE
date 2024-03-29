package com.medicine.Mapper.imp;

import com.medicine.Entity.Medicine;
import com.medicine.Mapper.MedicineMapper;
import com.medicine.Query.MedicineQuery;
import com.medicine.Util.JDBCHelper;

import java.util.List;

public class MedicineMapperImp implements MedicineMapper {
    private static final JDBCHelper jdbc = new JDBCHelper();

    public static void main(String[] args) {
        Medicine m = new Medicine();
        m.setMedicineNo("abc001");
        MedicineMapper mm = new MedicineMapperImp();
//        for (Medicine med : mm.select(m)) {
//            System.out.println(med);
//        }
    }

    @Override
    public boolean insert(Medicine m) {
        String sql = "INSERT INTO medicine(medicineNo,name,factoryAddress,description,price,expire,unit,number,categoryId,deleted) VALUES(?,?,?,?,?,?,?,?,?,?)";
        String[] values = new String[]{
                m.getMedicineNo(),
                m.getName(),
                m.getFactoryAddress(),
                m.getDescription(),
                String.valueOf(m.getPrice()),
                String.valueOf(m.getExpire()),
                m.getUnit(),
                String.valueOf(m.getNumber()),
                String.valueOf(m.getCategoryId()),
                String.valueOf(m.getDeleted())
        };
        return jdbc.insert(sql, values) > 0;
    }

    @Override
    public boolean delete(Medicine m) {
        String sql = "DELETE FROM medicine WHERE id=?";
        String[] values = new String[]{String.valueOf(m.getId())};
        return jdbc.delete(sql, values) > 0;
    }
//    @Override
//    public boolean deleteById(int id){
//        Medicine m = new Medicine();
//        m.setId(id);
//        return delete(m);
//    }
    @Override
    public boolean update(Medicine m) {
        String sql = "UPDATE medicine SET name=?, factoryAddress=?, description=?, price=?, expire=?, unit=?, number=?, categoryId=?, deleted=? WHERE medicineNo=?";
        String[] values = new String[]{
                m.getName(),
                m.getFactoryAddress(),
                m.getDescription(),
                String.valueOf(m.getPrice()),
                String.valueOf(m.getExpire()),
                m.getUnit(),
                String.valueOf(m.getNumber()),
                String.valueOf(m.getCategoryId()),
                String.valueOf(m.getDeleted()),
                m.getMedicineNo()
        };
        return jdbc.update(sql, values) > 0;
    }

    @Override
    public List<Medicine> selectAll() {
        String sql = "SELECT * FROM medicine";
//        String[] values = new String[]{m.getMedicineNo()};
        return jdbc.select(sql, null, Medicine.class);
    }

    @Override
    public List<Medicine> fuzzySelect(String key) {
        String sql = "SELECT * FROM medicine " +
                "WHERE id LIKE %" + key + "% " +
                "OR medicineNO LIKE %" + key + "% " +
                "OR name LIKE %" + key + "% " +
                "OR factoryAddress LIKE %" + key + "% " +
                "OR description LIKE %" + key + "% " +
                "OR price LIKE %" + key + "% " +
                "OR expire LIKE %" + key + "% " +
                "OR unit LIKE %" + key + "% " +
                "OR number LIKE %" + key + "% " +
                "OR categoryId LIKE %" + key + "% " +
                "OR deleted LIKE %" + key + "% ";
        return jdbc.select(sql, null, Medicine.class);
    }


    @Override
    public String getSqlMedicineQuery(MedicineQuery query) {
        StringBuilder sql = new StringBuilder("SELECT * FROM medicine WHERE deleted = 0");
        if (query == null) return sql.toString();

        if (query.getMedicineName() != null) {
            sql.append(" AND `name` LIKE \"%" + query.getMedicineName() + "%\"");
        }

        if (query.getMedicineMinPrice() != null){
            sql.append(" AND price >= " + query.getMedicineMinPrice());
        }

        if (query.getMedicineMaxPrice() != null){
            sql.append(" AND price <= " + query.getMedicineMaxPrice());
        }

        if (query.getDatePick() != null){
            sql.append(" AND expire <= \"" + query.getDatePick() + "\"");
        }

        if (query.getCategoryId() != null){
            sql.append(" AND categoryId = " + query.getCategoryId());
        }

        return sql.toString();
    }

    @Override
    public List<Medicine> search(MedicineQuery medicineQuery) {
        MedicineMapper mm = new MedicineMapperImp();
        String sql = mm.getSqlMedicineQuery(medicineQuery);
        return jdbc.select(sql,null,Medicine.class);
    }
}
