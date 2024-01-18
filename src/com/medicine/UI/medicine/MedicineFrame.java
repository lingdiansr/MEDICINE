package com.medicine.UI.medicine;

import com.eltima.components.ui.DatePicker;
import com.medicine.Entity.Category;
import com.medicine.Entity.Medicine;
import com.medicine.Mapper.CategoryMapper;
import com.medicine.Mapper.MedicineMapper;
import com.medicine.Mapper.imp.CategoryMapperImp;
import com.medicine.Mapper.imp.MedicineMapperImp;
import com.medicine.Query.MedicineQuery;
import com.medicine.UI.base.UIConstants;
import com.medicine.UI.base.UIConverter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MedicineFrame extends JFrame {

    private JPanel panel;

    private JPanel upPanel;

    private JScrollPane midPane;

    private JPanel downPanel;


    // upPanel -> START <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private JTextField medicineName;
    private JTextField medicineMinPrice;
    private JTextField medicineMaxPrice;
    private JComboBox<Category> medicineCategory;
    private DatePicker datePick;
    private JButton search;
    // upPanel -> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓

    // midPane -> START <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private JTable table;
    private DefaultTableModel tableModel;
    private Integer selectedMedicineId = UIConstants.SELECTED_ID;
    // midPane -> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓

    // downPanel -> START <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private JButton addMedicine;
    private JButton modifyMedicine;
    private JButton removeMedicine;
    private JButton refreshMedicine;

    private JButton addshopButton;
    private JButton shopButton;
    // downPanel -> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓

    // server -> START <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    // server -> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    public MedicineFrame() {
        initPanel();
        initFrame();
        medicineButtonListener();
        tableDataSelectedListener();
    }

    public static void main(String[] args) {
        new MedicineFrame();
    }

    private void initFrame() {
        UIConverter.initFrame(this, ("医药管理系统"));
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(1, 1));

        upPanel();
        midPane();
        downPanel();
        this.getContentPane().add(upPanel, BorderLayout.NORTH);
        this.getContentPane().add(midPane, BorderLayout.CENTER);
        this.getContentPane().add(downPanel, BorderLayout.SOUTH);
    }

    private void upPanel() {
        upPanel = new JPanel();
        upPanel.setLayout(new GridLayout(0, 5));

        // 1.药品名称查询 容器初始化
        medicineName = UIConverter.initTextField();
        upPanel.add(UIConverter.getLabelAndComponentGroup("药品名称:", medicineName));

        // 2.药品价格查询 容器初始化
        JPanel price = new JPanel();
        price.setLayout(new GridLayout(0, 3));
        medicineMinPrice = UIConverter.initTextField();
        medicineMaxPrice = UIConverter.initTextField();
        price.add(medicineMinPrice, BorderLayout.WEST);
        price.add(UIConverter.initLabel(" - "), BorderLayout.CENTER);
        price.add(medicineMaxPrice, BorderLayout.EAST);
        upPanel.add(UIConverter.getLabelAndComponentGroup("药品价格:", price));

        // 3.所属类别查询 容器初始化
        medicineCategory = initCategoryData(true);
        upPanel.add(UIConverter.getLabelAndComponentGroup("所属类别:", medicineCategory));

        // 4.有效期查询 容器初始化
        datePick = UIConverter.getDatePicker(dealDate(true));
        upPanel.add(UIConverter.getLabelAndComponentGroup("有效期至:", datePick));

        // 5.查询按钮 容器初始化
        search = UIConverter.initButton("查询");
        upPanel.add(search);
    }

    private void midPane() {
        loadTableData();

        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 重写:让所有单元格不可编辑
            }
        };

        hideMedicineId();

        midPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

    }

    private void downPanel() {
        addMedicine = UIConverter.initButton("新增");
        modifyMedicine = UIConverter.initButton("修改");
        removeMedicine = UIConverter.initButton("删除");
        refreshMedicine = UIConverter.initButton("刷新");

        addshopButton=UIConverter.initButton("加入购物车");
        shopButton = UIConverter.initButton("购物车");

        downPanel = new JPanel();
        downPanel.add(addMedicine);
        downPanel.add(modifyMedicine);
        downPanel.add(removeMedicine);
        downPanel.add(refreshMedicine);

        downPanel.add(addshopButton);
        downPanel.add(shopButton);
    }

    public JComboBox<Category> initCategoryData(boolean isSearch) {
        JComboBox<Category> target = new JComboBox<>();
        target.setFont(new Font(UIConstants.FONT_NAME_SONG, Font.PLAIN, 12));
        // todo 对类别进行赋值
        target.addItem(new Category(-1, "所有类别", ""));
        CategoryMapper mp = new CategoryMapperImp();
        for (Category c : mp.selectAll()) {
            target.addItem(c);
        }
        return target;
    }

    public Date dealDate(boolean deal) {
        if (Boolean.FALSE.equals(deal)) {
            return new Date();
        } else {
            LocalDate threeYearsLater = LocalDate.now().plusYears(3L);
            return Date.from(threeYearsLater.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    }

    private void medicineButtonListener() {
        // 1.监听查询按钮
        search.addActionListener(ae -> searchButtonListener());

        // 2.监听添加按钮
        addMedicine.addActionListener(ae -> new AddMedicineFrame(MedicineFrame.this, true));


        // 3.监听删除按钮
        removeMedicine.addActionListener(ae -> removeButtonListener());

        // 4.监听修改按钮
        modifyMedicine.addActionListener(ae -> {
            if (Objects.equals(selectedMedicineId, UIConstants.SELECTED_ID)) {
                JOptionPane.showMessageDialog(MedicineFrame.this, "请先选择要修改的数据");
            } else {
                // todo 获取到当前药品对象，打开新的弹框
                // 获取表格中的一行数据
                int selectedRow = table.getSelectedRow();
                int id = Integer.parseInt((String) table.getValueAt(selectedRow, UIConstants.MEDICINE_ID));
                String medicineNo = (String) table.getValueAt(selectedRow, 1);
                String name = (String) table.getValueAt(selectedRow, 2);
                String factoryAddress = (String) table.getValueAt(selectedRow, 4);
                String description = (String) table.getValueAt(selectedRow, 3);
                double price = Double.parseDouble((String) table.getValueAt(selectedRow, 7));
                String expire = (String) table.getValueAt(selectedRow, 5);
                String unit = (String) table.getValueAt(selectedRow, 8);
                int number = Integer.parseInt((String) table.getValueAt(selectedRow, 6));
                CategoryMapper cp = new CategoryMapperImp();
                int categoryId = cp.selectIdByName((String) table.getValueAt(selectedRow, 9)).get(0).getId();
                int deleted = 0;

                // 封装成Medicine对象
                Medicine medicine = new Medicine(id, medicineNo, name, factoryAddress, description, price, expire, unit, number, categoryId, deleted);
                System.out.println(medicine);

                new ModifyMedicineFrame(MedicineFrame.this, true, medicine);
            }
        });

        // 5.监听刷新按钮
        refreshMedicine.addActionListener(ae -> refreshButtonListener());

        addshopButton.addActionListener(ae->addshopListener());
        shopButton.addActionListener(ae->shopListener());
    }

    private void tableDataSelectedListener() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //获得选中行
                int selectRow = table.getSelectedRow();
                if (selectRow != UIConstants.SELECTED_ID) {
                    //找到隐藏的药品mid
                    String midStr = tableModel.getValueAt(selectRow, UIConstants.MEDICINE_ID).toString();
                    selectedMedicineId = Integer.parseInt(midStr);
                }
            }
        });
    }

    public void searchButtonListener() {
        loadTableData();
        table.setModel(tableModel);
        hideMedicineId();
        selectedMedicineId = UIConstants.SELECTED_ID; // 查询后 , 重置表格选择的药品Id
    }

    private void removeButtonListener() {
        if (Objects.equals(selectedMedicineId, UIConstants.SELECTED_ID)) {
            JOptionPane.showMessageDialog(this, "请选择需要删除的药品数据!");
        } else {
            int choose = JOptionPane.showConfirmDialog(this, "您确认要删除该条记录？", "药品删除", JOptionPane.YES_NO_OPTION);

            if (choose == JOptionPane.YES_OPTION) {
                // todo 删除逻辑
                int selectedRow = table.getSelectedRow();
                int id = Integer.parseInt((String) table.getValueAt(selectedRow, UIConstants.MEDICINE_ID));
                MedicineMapper mm = new MedicineMapperImp();
                Medicine m = new Medicine();
                m.setId(id);
                if (mm.delete(m)){
                    JOptionPane.showMessageDialog(this, "删除成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(this, "删除失败", "失败", JOptionPane.ERROR_MESSAGE);
                }
            }
            searchButtonListener(); // 刷新加载数据
        }
    }

    private void refreshButtonListener() {
        clearMedicineQuery();
        searchButtonListener();
    }

    private void hideMedicineId() {
        if (table != null) {
            // 隐藏 药品主键Id
            table.getColumnModel().getColumn(UIConstants.MEDICINE_ID).setMinWidth(0);
            table.getColumnModel().getColumn(UIConstants.MEDICINE_ID).setMaxWidth(0);
            table.getColumnModel().getColumn(UIConstants.MEDICINE_ID).setPreferredWidth(0);
        }
    }

    private void loadTableData() {
        if (tableModel != null) {
            tableModel = null;
        }
        // todo 查询药品列表
        MedicineQuery medicineQuery = getMedicineQuery();
        MedicineMapper medicineMapper = new MedicineMapperImp();
        CategoryMapper categoryMapper = new CategoryMapperImp();

        List<Medicine> medicines = medicineMapper.search(medicineQuery);
        List<Category> categories = categoryMapper.selectAll();
        // 赋值给tablemodel
        tableModel = UIConverter.getMedicineData(medicines, categories);
    }

    private MedicineQuery getMedicineQuery() {
        // TODO 一些过滤条件 , 价格的简单判断
        String medicineNameStr = this.medicineName.getText();
        String medicineMinPriceStr = this.medicineMinPrice.getText();
        String medicineMaxPriceStr = this.medicineMaxPrice.getText();
        String categoryId = String.valueOf(((Category) Objects.requireNonNull(this.medicineCategory.getSelectedItem())).getId());
        String datePickStr = this.datePick.getText();
        return MedicineQuery.from(medicineNameStr, medicineMinPriceStr, medicineMaxPriceStr, categoryId, datePickStr);
    }

    private void clearMedicineQuery() {
        // todo 清除查询条件
//        medicineName = UIConverter.initTextField();
//        medicineMinPrice = UIConverter.initTextField();
//        medicineMaxPrice = UIConverter.initTextField();
//        medicineCategory = initCategoryData(true);
//        datePick = UIConverter.getDatePicker(dealDate(true));
        medicineName.setText(null);
        medicineMinPrice.setText(null);
        medicineMaxPrice.setText(null);
        medicineCategory.setSelectedIndex(0);
//        datePick.setLocale(new Locale(new Date()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datePick.getInnerTextField().setText(dateFormat.format(dealDate(true)));
    }

    private void addshopListener(){
        addshopButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Objects.equals(selectedMedicineId, UIConstants.SELECTED_ID)) {
                    JOptionPane.showMessageDialog(MedicineFrame.this, "请先选择要添加的数据");
                } else {
                    // todo 获取到当前药品对象，打开新的弹框
                    // 获取表格中的一行数据
                    int selectedRow = table.getSelectedRow();
//                    int id = Integer.parseInt((String) table.getValueAt(selectedRow, UIConstants.MEDICINE_ID));
//                    String medicineNo = (String) table.getValueAt(selectedRow, 1);
                    String name = (String) table.getValueAt(selectedRow, 2);
//                    String factoryAddress = (String) table.getValueAt(selectedRow, 4);
                    String description = (String) table.getValueAt(selectedRow, 3);
                    double price = Double.parseDouble((String) table.getValueAt(selectedRow, 7));
//                    String expire = (String) table.getValueAt(selectedRow, 5);
//                    String unit = (String) table.getValueAt(selectedRow, 8);
//                    int number = Integer.parseInt((String) table.getValueAt(selectedRow, 6));
                    CategoryMapper cp = new CategoryMapperImp();
                    int categoryId = cp.selectIdByName((String) table.getValueAt(selectedRow, 9)).get(0).getId();
//                    int deleted = 0;

                    // 封装成Medicine对象
                    Medicine medicine = new Medicine(name, description, price, categoryId);
                    System.out.println(medicine);
                    shop s = new shop();
                    s.addMedicineToTable(name, description, price, categoryId);
//                    new ModifyMedicineFrame(MedicineFrame.this, true, medicine);
                }
            }
        });

    }
    private void shopListener(){
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new shop();
                Medicine selectedMedicine = getSelectedMedicine();
                if (selectedMedicine != null) {
                    // 将选中的药品信息添加到表格中
                    tableModel.addRow(new Object[]{selectedMedicine.getName(), selectedMedicine.getDescription(), selectedMedicine.getPrice(), selectedMedicine.getCategoryId()});
                }

            }
        });

    }
    public Medicine getSelectedMedicine() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String medicineName = table.getValueAt(selectedRow, 0).toString();
            String medicineDescription = table.getValueAt(selectedRow, 1).toString();
            double medicineprice = (double) table.getValueAt(selectedRow, 2);
            int medicineCategoryId = (int) table.getValueAt(selectedRow, 3);

            return new Medicine(medicineName, medicineDescription,medicineprice,medicineCategoryId);
        } else {
            return null;
        }
    }

}
