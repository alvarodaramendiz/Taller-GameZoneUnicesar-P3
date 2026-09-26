package com.gamezone.ui;

import com.gamezone.model.Customer;
import com.gamezone.model.Seller;
import com.gamezone.model.Shift;
import com.gamezone.service.CustomerService;
import com.gamezone.service.SellerService;
import com.gamezone.service.ProductService;
import com.gamezone.service.ReturnService;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for registering customers and listing customers/sellers.
 *
 * @author jahdiel
 */
public class ReturnPanel extends JPanel {

    private CustomerService customerService = new CustomerService();
    private SellerService sellerService = new SellerService();
    private ReturnService returnService = new ReturnService();

    private JTextField txtReason, txtName, txtId, txtValue, txtMonth, txtYear;
    private JComboBox<String> comboProducts;
    private JTable returnsTable, viewReturnsTable, reportTable;
    private DefaultTableModel returnsTableModel, viewReturnsTableModel, reportTableModel;

    public ReturnPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Registro de Devoluciones", createReturnsTab());
        tabs.addTab("Lista de Devoluciones", createViewTab());
        tabs.addTab("Consulta de Balance Mensual", createReportTab());

        add(tabs, BorderLayout.CENTER);
    }

    private JPanel createReturnsTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(2, 4, 8, 8));
        JPanel formId = new JPanel(new GridLayout(2, 4, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Registro de Devoluciones"));
        formId.setBorder(BorderFactory.createTitledBorder("Buscar Transacción"));
        
        txtReason = new JTextField();
        comboProducts = new JComboBox<>();
        txtId = new JTextField();
        txtValue = new JTextField();
        
        JButton btnSearchId = new JButton("Buscar transacción");
        btnSearchId.addActionListener(e -> searchId());
        
        formId.add(new JLabel("Número de Transacción:"));
        formId.add(txtId);
        formId.add(btnSearchId, BorderLayout.CENTER);
        
        form.add(new JLabel("Productos:"));
        form.add(comboProducts);
        form.add(new JLabel("Motivo de Devolución:"));
        form.add(txtReason);
        form.add(new JLabel("Reembolso:"));
        form.add(txtValue);

        JButton btnRegister = new JButton("Registrar devolución");
        btnRegister.addActionListener(e -> registerReturn());
        form.add(btnRegister, BorderLayout.CENTER);

        JPanel formWrapper = new JPanel(new BorderLayout());
        formWrapper.add(formId, BorderLayout.NORTH);
        formWrapper.add(form, BorderLayout.SOUTH);

        returnsTableModel = new DefaultTableModel(
                new String[]{"Número de Transacción", "Productos", "Motivo de Devolución", "Reembolso"}, 0);
        returnsTable = new JTable(returnsTableModel);

        panel.add(formWrapper, BorderLayout.NORTH);
        panel.add(new JScrollPane(returnsTable), BorderLayout.CENTER);

        refreshReturnsTable();
        return panel;
    }

    private JPanel createViewTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        viewReturnsTableModel = new DefaultTableModel(
                new String[]{"Número de Transacción", "Productos", "Motivo de Devolución", "Reembolso"}, 0);
        viewReturnsTable = new JTable(viewReturnsTableModel);

        JButton btnRefresh = new JButton("Actualizar lista");
        btnRefresh.addActionListener(e -> refreshViewTable());

        panel.add(btnRefresh, BorderLayout.NORTH);
        panel.add(new JScrollPane(viewReturnsTable), BorderLayout.CENTER);

        refreshViewTable();
        return panel;
    }
    
    private JPanel createReportTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel form = new JPanel(new GridLayout(2, 4, 8, 8));

        form.setBorder(BorderFactory.createTitledBorder("Consulta de Balance Mensual"));

        txtMonth = new JTextField();
        txtYear = new JTextField();

        form.add(new JLabel("Mes:"));
        form.add(txtMonth);
        form.add(new JLabel("Año:"));
        form.add(txtYear);

        JButton btnSearch = new JButton("Buscar");
        btnSearch.addActionListener(e -> refreshReportTable());
        JButton btnShow = new JButton("Mostrar todos");
        btnSearch.addActionListener(e -> showReportTable());

        JPanel formWrapper = new JPanel(new BorderLayout());
        formWrapper.add(form, BorderLayout.CENTER);
        formWrapper.add(btnSearch, BorderLayout.SOUTH);

        reportTableModel = new DefaultTableModel(
                new String[]{"Mes", "Año", "Ganancias", "Costo Devoluciones", "Balance Neto"}, 0);
        reportTable = new JTable(reportTableModel);

        panel.add(formWrapper, BorderLayout.NORTH);
        panel.add(new JScrollPane(reportTable), BorderLayout.CENTER);
        
        refreshReportTable();
        return panel;
    }
    
    private void searchReport() {
        // implementar cuando se complete ReturnService y ReturnPersistence
    }
    
    private void searchId() {
        // implementar cuando se complete ReturnService y ReturnPersistence
    }

    private void registerReturn() {
//        try {
//            String email = txtReason.getText();
//            String name = txtName.getText();
//            long id = Long.parseLong(txtId.getText());
//            long contact = Long.parseLong(txtValue.getText());
//
//            customerService.registerCustomer(email, name, id, contact);
//            JOptionPane.showMessageDialog(this, "Cliente registrado con éxito.");
//            refreshReturnsTable();
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "ID y contacto deben ser números válidos.");
//        } catch (IllegalArgumentException e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
    }

    private void refreshReturnsTable() {
//        returnsTableModel.setRowCount(0);
//        ArrayList<Customer> customers = customerService.listCustomers();
//        for (Customer c : customers) {
//            returnsTableModel.addRow(new Object[]{
//                    c.getiD(), c.getName(), c.geteMail(), c.getContactNumber()
//            });
//        }
    }

    private void refreshViewTable() {
//        viewReturnsTableModel.setRowCount(0);
//        ArrayList<Seller> sellers = sellerService.listSellers();
//        for (Seller s : sellers) {
//            viewReturnsTableModel.addRow(new Object[]{
//                    s.getEmployeeCode(), s.getName(), s.getShift(), s.getiD(), s.getContactNumber()
//            });
//        }
    }
    
    
    private void showReportTable() {
        // Desarrollar cuando se complete ReturnService y RreturnPersistence
    }
        
    private void refreshReportTable() {
        // Desarrollar cuando se complete ReturnService y RreturnPersistence
    }
}