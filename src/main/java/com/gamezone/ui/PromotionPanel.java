package com.gamezone.ui;



import com.gamezone.model.Customer;
import com.gamezone.model.Seller;
import com.gamezone.model.Shift;
import com.gamezone.service.PromotionService;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for promotions.
 *
 * @author alvaro
 */
public class PromotionPanel extends JPanel {

    private JTextField txtDateStart, txtName, txtId, txtDateEnd, txtPercentage;
    private JComboBox<String> comboPromotions, comboCategory;
    private JTable registerPromotionsTable, ViewPromotionsTable, availablePromotionsTable;
    private DefaultTableModel registerPromotionsTableModel, ViewPromotionsTableModel, availablePromotionsTableModel;

    public PromotionPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Registro de Promociones", registerPromotionsTab());
        tabs.addTab("Lista de Promociones", ViewPromotionsTab());
        tabs.addTab("Promociones Vigentes", availablePromotionsTab());

        add(tabs, BorderLayout.CENTER);
    }

    private JPanel registerPromotionsTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel registerPane = new JPanel(new GridLayout(2, 4));
        JPanel inputPane = new JPanel(new GridLayout(2, 4, 8, 8));
        JPanel comboPane = new JPanel(new GridLayout(2, 4, 8, 8));
        
        JPanel idPane = new JPanel(new GridLayout(2, 4, 8, 8));
        JPanel datePane = new JPanel(new GridLayout(2, 4, 8, 8));
        
        JLabel category;
        registerPane.setBorder(BorderFactory.createTitledBorder("Registro de Promociones"));
        inputPane.setBorder(BorderFactory.createTitledBorder("Ingresar Datos"));
        comboPane.setBorder(BorderFactory.createTitledBorder("Selección de Promociones"));
        
        txtDateStart = new JTextField();
        comboPromotions = new JComboBox<>(new String[]{"Porcentaje","Categoría","Volumen"});
        comboCategory = new JComboBox<>(new String[]{"Consola","Videojuego"});
        txtId = new JTextField();
        txtDateEnd = new JTextField();
        category = new JLabel("Categoría:");
        
        category.setVisible(false);
        comboCategory.setVisible(false);

        comboCategory.addActionListener(e ->{// Desarrollar al completar persistencia, modelo y servicio
        });
        
        comboPromotions.addActionListener(e ->{
            
            String option = comboPromotions.getSelectedItem().toString();
            
            if (option.equals("Categoría")) {
                category.setVisible(true);
                comboCategory.setVisible(true);
            } else {
                category.setVisible(false);
                comboCategory.setVisible(false);
            }
            
        });
        
        idPane.add(new JLabel("ID de la Promoción:"));
        idPane.add(txtId);
        
        comboPane.add(new JLabel("Promociones:"));
        comboPane.add(comboPromotions);
        
        comboPane.add(category);
        comboPane.add(comboCategory);
        
        datePane.add(new JLabel("Fecha de inicio:"));
        datePane.add(txtDateStart, BorderLayout.NORTH);
        datePane.add(new JLabel("Vencimiento:"));
        datePane.add(txtDateEnd, BorderLayout.SOUTH);
        
        inputPane.add(idPane, BorderLayout.WEST);
        inputPane.add(datePane, BorderLayout.EAST);

        JButton btnRegister = new JButton("Registrar promoción");
        btnRegister.addActionListener(e -> registerPromotion());
        registerPane.add(btnRegister, BorderLayout.NORTH);

        JPanel paneWrapper = new JPanel(new BorderLayout());
        paneWrapper.add(inputPane, BorderLayout.NORTH);
        paneWrapper.add(comboPane, BorderLayout.SOUTH);

        registerPromotionsTableModel = new DefaultTableModel(
                new String[]{"ID de Promoción", "Promoción", "Tipo", "Fecha inicio", "Vencimiento"}, 0);
        registerPromotionsTable = new JTable(registerPromotionsTableModel);

        panel.add(paneWrapper, BorderLayout.NORTH);
        panel.add(registerPane, BorderLayout.SOUTH);
        panel.add(new JScrollPane(registerPromotionsTable), BorderLayout.CENTER);

        refreshPromotionsTable();
        return panel;
    }

    private JPanel ViewPromotionsTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        ViewPromotionsTableModel = new DefaultTableModel(
                new String[]{"ID de Promoción", "Promoción", "Tipo", "Fecha inicio", "Vencimiento"}, 0);
        ViewPromotionsTable = new JTable(ViewPromotionsTableModel);

        JButton btnRefresh = new JButton("Actualizar lista");
        btnRefresh.addActionListener(e -> refreshViewTable());

        panel.add(btnRefresh, BorderLayout.NORTH);
        panel.add(new JScrollPane(ViewPromotionsTable), BorderLayout.CENTER);

        refreshViewTable();
        return panel;
    }
    
    private JPanel availablePromotionsTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JButton btnUpdate = new JButton("Actualizar lista vigentes");
        btnUpdate.addActionListener(e -> refreshAvailablesTable());

        JPanel updatePane = new JPanel(new BorderLayout());
        updatePane.add(btnUpdate, BorderLayout.SOUTH);

        availablePromotionsTableModel = new DefaultTableModel(
                new String[]{"ID de Promoción", "Promoción", "Tipo", "Fecha inicio", "Vencimiento"}, 0);
        availablePromotionsTable = new JTable(availablePromotionsTableModel);

        panel.add(updatePane, BorderLayout.NORTH);
        panel.add(new JScrollPane(availablePromotionsTable), BorderLayout.CENTER);
        
        refreshAvailablesTable();
        return panel;
    }
    

    private void registerPromotion() {
//        try {
//            String email = txtDateStart.getText();
//            String name = txtName.getText();
//            long id = Long.parseLong(txtId.getText());
//            long contact = Long.parseLong(txtDateEnd.getText());
//
//            customerService.registerCustomer(email, name, id, contact);
//            JOptionPane.showMessageDialog(this, "Cliente registrado con éxito.");
//            refreshPromotionsTable();
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "ID y contacto deben ser números válidos.");
//        } catch (IllegalArgumentException e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
    }

    private void refreshPromotionsTable() {
//        registerPromotionsTableModel.setRowCount(0);
//        ArrayList<Customer> customers = customerService.listCustomers();
//        for (Customer c : customers) {
//            registerPromotionsTableModel.addRow(new Object[]{
//                    c.getiD(), c.getName(), c.geteMail(), c.getContactNumber()
//            });
//        }
    }

    private void refreshViewTable() {
//        ViewPromotionsTableModel.setRowCount(0);
//        ArrayList<Seller> sellers = sellerService.listSellers();
//        for (Seller s : sellers) {
//            ViewPromotionsTableModel.addRow(new Object[]{
//                    s.getEmployeeCode(), s.getName(), s.getShift(), s.getiD(), s.getContactNumber()
//            });
//        }
    }

    private void refreshAvailablesTable() {
        // Desarrollar cuando se complete ReturnService y RreturnPersistence
    }
}