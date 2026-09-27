package com.gamezone.ui;

import com.gamezone.service.CustomerService;
import com.gamezone.service.SellerService;
import com.gamezone.service.ProductService;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for consulting warranties.
 *
 * @author jahdiel
 */
public class WarrantyPanel extends JPanel {

    private CustomerService customerService = new CustomerService();
    private SellerService sellerService = new SellerService();

    private JTextField txtSaleId;
    private JComboBox<String> comboProducts;

    private JTable warrantyTable, viewWarrantyTable;
    private DefaultTableModel warrantyTableModel, viewWarrantyTableModel;

    public WarrantyPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Consultar Garantía", createReturnsTab());
        tabs.addTab("Lista de Garantías", createViewTab());

        add(tabs, BorderLayout.CENTER);
    }

    private JPanel createReturnsTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(2, 4, 8, 8));
        JPanel formSearch = new JPanel(new GridLayout(2, 4, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Buscar Garantía de Producto"));
        formSearch.setBorder(BorderFactory.createTitledBorder("Buscar Venta"));
        
        txtSaleId = new JTextField();
        comboProducts = new JComboBox<>();
        
        
        formSearch.add(new JLabel("Número de Transacción:"));
        formSearch.add(txtSaleId);
        
        form.add(new JLabel("Productos:"));
        form.add(comboProducts);
        
        JButton btnSearch = new JButton("Buscar Venta");
        btnSearch.addActionListener(e -> searchWarranty());
        formSearch.add(btnSearch, BorderLayout.CENTER);

        JButton btnRegister = new JButton("Comprobar Garantía");
        btnRegister.addActionListener(e -> searchWarranty());
        form.add(btnRegister, BorderLayout.CENTER);

        JPanel formWrapper = new JPanel(new BorderLayout());
        formWrapper.add(formSearch, BorderLayout.NORTH);
        formWrapper.add(form, BorderLayout.SOUTH);

        warrantyTableModel = new DefaultTableModel(
                new String[]{"Transacción", "Producto asociado", "Garantía", "Estado"}, 0);
        warrantyTable = new JTable(warrantyTableModel);

        panel.add(formWrapper, BorderLayout.NORTH);
        panel.add(new JScrollPane(warrantyTable), BorderLayout.CENTER);

        refreshWarrantyTable();
        return panel;
    }

    private JPanel createViewTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel panelAll = new JPanel();
        JPanel panelTypesView = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));

        viewWarrantyTableModel = new DefaultTableModel(
                new String[]{"Transacción", "Producto asociado", "Garantía", "Estado"}, 0);
        viewWarrantyTable = new JTable(viewWarrantyTableModel);

        JButton btnViewAll = new JButton("Ver todas las garantías");
        btnViewAll.addActionListener(e -> RefreshViewAllWarranties());
        
        JButton btnAvailable = new JButton("Garantías vigentes");
        btnAvailable.addActionListener(e -> RefreshAvailableWarranties());
        
        JButton btnSoonExpire = new JButton("Garantías por expirar");
        btnSoonExpire.addActionListener(e -> RefreshSoonToExpireWarranties());

        panelAll.add(btnViewAll, BorderLayout.NORTH);
        panelTypesView.add(btnAvailable);
        panelTypesView.add(btnSoonExpire);
        panel.add(panelAll, BorderLayout.PAGE_START);
        panel.add(panelTypesView, BorderLayout.CENTER);
        panel.add(new JScrollPane(viewWarrantyTable), BorderLayout.SOUTH);

        RefreshViewAllWarranties();
        return panel;
    }
    
    
    private void searchWarranty() {
        // implementar cuando se complete ReturnService y ReturnPersistence
    }
    
        private void searchSale() {
        // implementar cuando se complete ReturnService y ReturnPersistence
    }
    

    private void refreshWarrantyTable() {
//        warrantyTableModel.setRowCount(0);
//        ArrayList<Customer> customers = customerService.listCustomers();
//        for (Customer c : customers) {
//            warrantyTableModel.addRow(new Object[]{
//                    c.getiD(), c.getName(), c.geteMail(), c.getContactNumber()
//            });
//        }
    }

    private void RefreshViewAllWarranties() {
//        viewWarrantyTableModel.setRowCount(0);
//        ArrayList<Seller> sellers = sellerService.listSellers();
//        for (Seller s : sellers) {
//            viewWarrantyTableModel.addRow(new Object[]{
//                    s.getEmployeeCode(), s.getName(), s.getShift(), s.getiD(), s.getContactNumber()
//            });
//        }
    }
    
    private void RefreshAvailableWarranties() {
        
    }
    
    private void RefreshSoonToExpireWarranties() {
        
    }
    
}