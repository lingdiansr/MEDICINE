package com.medicine.UI.medicine;

import com.eltima.components.ui.DatePicker;
import com.medicine.Entity.Category;
import com.medicine.Entity.Medicine;
import com.medicine.Mapper.MedicineMapper;
import com.medicine.Mapper.imp.MedicineMapperImp;
import com.medicine.UI.base.UIConstants;
import com.medicine.UI.base.UIConverter;


import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ModifyMedicineFrame extends JDialog {

    JPanel panel;

    private JPanel upPanel;

    private JPanel midPane;

    private JPanel downPanel;

    private final MedicineFrame medicineFrame;

    private Medicine medicine;

    // upPanel -> START <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // upPanel -> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓

    // midPane -> START <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private JTextField medicineNo;                      // 药品编号
    private JTextField medicineName;                    // 药品名称
    private JTextField medicineDescription;             // 药品描述
    private JTextField medicineFactoryAddress;          // 药品厂家
    private DatePicker datePick;                        // 药品有效期
    private JTextField medicineNumber;                  // 药品数量
    private JTextField medicinePrice;                   // 药品价格
    private JTextField medicineUnit;                    // 药品单位
    private JComboBox<Category> medicineCategory;       // 药品类别
    // midPane -> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓

    // downPanel -> START <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private JButton modify;

    private JButton cancel;
    // downPanel -> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓
    // ↓        ↓       ↓        ↓       ↓        ↓       ↓        ↓       ↓

    // server -> START <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // server -> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public ModifyMedicineFrame(Frame owner, boolean modal, Medicine medicine) {
        super(owner, modal);
        medicineFrame = (MedicineFrame) owner;
        this.medicine = medicine;
        initPanel();
        medicineButtonListener();
        UIConverter.initDialog(this, owner, "新增药品");
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(1, 1));

        midPane();
        downPanel();
        upPanel();

        this.getContentPane().add(upPanel, BorderLayout.NORTH);
        this.getContentPane().add(midPane, BorderLayout.CENTER);
        this.getContentPane().add(UIConverter.initBlankLabel(), BorderLayout.WEST);
        this.getContentPane().add(UIConverter.initBlankLabel(), BorderLayout.EAST);
        this.getContentPane().add(downPanel, BorderLayout.SOUTH);
    }

    private void upPanel() {
        JLabel text = new JLabel("修改药品");
        text.setHorizontalTextPosition(SwingConstants.CENTER);
        text.setForeground(Color.BLUE);
        text.setFont(new Font(UIConstants.FONT_NAME_SONG, Font.PLAIN, 40));
        text.setSize(350, 60);
        upPanel = new JPanel();
        upPanel.add(text);
    }

    private void midPane() {
        midPane = new JPanel();
        LayoutManager layout = new BoxLayout(midPane, BoxLayout.PAGE_AXIS);
        midPane.setLayout(layout);

        // 1.药品编号 初始化
        medicineNo = UIConverter.initTextField();
        medicineNo.setText(medicine.getMedicineNo());
        midPane.add(createFiledJPanel("药品编号:", medicineNo));

        // 2.药品名称 初始化
        medicineName = UIConverter.initTextField();
        medicineName.setText(medicine.getName());
        midPane.add(createFiledJPanel("药品名称:", medicineName));


        // 3.药品描述 初始化
        medicineDescription = UIConverter.initTextField();
        medicineDescription.setText(medicine.getDescription());
        midPane.add(createFiledJPanel("药品描述:", medicineDescription));

        // 4.药品厂家 初始化
        medicineFactoryAddress = UIConverter.initTextField();
        medicineFactoryAddress.setText(medicine.getFactoryAddress());
        midPane.add(createFiledJPanel("药品厂家:", medicineFactoryAddress));

        // 5.有效期 容器初始化
        datePick = UIConverter.getDatePicker(medicineFrame.dealDate(true));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            datePick = UIConverter.getDatePicker(dateFormat.parse(String.valueOf(medicine.getExpire())));
        } catch (ParseException e) {
            System.out.println("有效期获取失败!");
            e.printStackTrace();
        }
        midPane.add(createFiledJPanel("有效期至:", datePick));

        // 6.药品名称 初始化
        medicineNumber = UIConverter.initTextField();
        medicineNumber.setText(String.valueOf(medicine.getNumber()));
        midPane.add(createFiledJPanel("药品数量:", medicineNumber));

        // 7.药品价格 初始化
        medicinePrice = UIConverter.initTextField();
        medicinePrice.setText(String.valueOf(medicine.getPrice()));
        midPane.add(createFiledJPanel("药品价格:", medicinePrice));

        // 8.药品单位 初始化
        medicineUnit = UIConverter.initTextField();
        medicineUnit.setText(String.valueOf(medicine.getUnit()));
        midPane.add(createFiledJPanel("药品单位:", medicineUnit));

        // 9.所属类别查询 容器初始化
        medicineCategory = medicineFrame.initCategoryData(true);
        // todo  获取类别列表注入到item中

        medicineCategory.setSelectedItem(medicine.getCategoryId());
        midPane.add(createFiledJPanel("所属类别:", medicineCategory));
    }

    private JPanel createFiledJPanel(String labelContext, JComponent component) {
        JPanel result = UIConverter.getLabelAndComponentGroup(labelContext, 15, component);
        result.setSize(280, 0);
        return result;
    }

    private void downPanel() {
        modify = UIConverter.initButton("修改");
        cancel = UIConverter.initButton("取消");

        downPanel = new JPanel();
        downPanel.add(modify);
        downPanel.add(cancel);
    }


    private void medicineButtonListener() {
        modify.addActionListener(ae -> modifyButtonListener());
        cancel.addActionListener(ae -> this.dispose());
    }

    private void modifyButtonListener() {
        medicine.setMedicineNo(medicineNo.getText());
        medicine.setDescription(medicineDescription.getText());
        medicine.setName(medicineName.getText());
        medicine.setFactoryAddress(medicineFactoryAddress.getText());
        medicine.setNumber(Integer.parseInt(medicineNumber.getText()));
        medicine.setPrice(Double.parseDouble(medicinePrice.getText()));
        medicine.setUnit(medicineUnit.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        medicine.setExpire();
        medicine.setExpire(datePick.getText());
        medicine.setCategoryId((((Category) Objects.requireNonNull(medicineCategory.getSelectedItem()))).getId());
        MedicineMapper mm = new MedicineMapperImp();
        if (medicine.getCategoryId() != -1 && mm.update(medicine)) {
            JOptionPane.showMessageDialog(this, "修改成功", "成功", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "修改失败", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
