package com.medicine.UI.medicine;

import com.medicine.UI.base.UIConstants;
import com.medicine.UI.base.UIConverter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class shop extends JFrame implements ActionListener {
    private JPanel tablepanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JButton backButton=new JButton("返回");
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private Integer selectedMedicineId = UIConstants.SELECTED_ID;

    private Vector<String> columnNames; // 列名向量
    private Vector<Vector<Object>> data; // 数据向量

    public shop(){
        initPanel();
        initFrame();
        this.setVisible(true);
    }
//    public shop(){
//
//    }
    public void initFrame(){
        UIConverter.initFrame(this, ("购物车"));
    }
    public void initPanel(){
        panel.setLayout(new BorderLayout());

        // 初始化列名向量
        columnNames = new Vector<>();
        columnNames.add("药品名称");
        columnNames.add("药品描述");
//        columnNames.add("规格");
        columnNames.add("价格");
        columnNames.add("药品类别");
//        columnNames.add("总价");

        // 初始化数据向量
        data = new Vector<>();

        // 初始化表格模型
        tableModel = new DefaultTableModel(data, columnNames);

        // 初始化表格
        table = new JTable(tableModel);
        table.setRowHeight(30); // 设置行高

        // 设置JTable的列默认的宽度和高度
        TableColumn column = null;
        int colunms = table.getColumnCount();
        for(int i = 0; i < colunms; i++) {
            column = table.getColumnModel().getColumn(i);
            /*将每一列的默认宽度设置为100*/
            column.setPreferredWidth(100);
        }

        // 初始化滚动面板
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        buttonPanel.add(backButton);
        backButton.addActionListener(this);
        panel.add(scrollPane, BorderLayout.CENTER); // 将表格添加到滚动面板中
        panel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(panel);
    }

//    public shop(Frame owner, boolean modal, Medicine medicine) {
//        super(owner, modal);
//        shop= (shop) owner;
//        this.medicine = medicine;
//        initPanel();
//        medicineButtonListener();
//        UIConverter.initDialog(this, owner, "新增药品");
//    }
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

    public static void main(String[] args){
        new shop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            this.dispose();
            new MedicineFrame();
        }
    }
    public void addMedicineToTable( String name,String description,double price,int categoryId) {
        // 创建一行数据
        Vector<Object> row = new Vector<>();
        row.add(name);
        row.add(description);
        row.add(price);
        row.add(categoryId);
        // 设置其他列的值，例如数量和总价
        // ...

        // 将数据添加到表格模型
        tableModel.addRow(row);
    }

}
