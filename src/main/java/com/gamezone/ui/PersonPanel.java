package com.gamezone.ui;

import com.gamezone.exceptions.BusinessRuleException;
import com.gamezone.exceptions.InvalidDataException;
import com.gamezone.exceptions.PersistenceException;
import com.gamezone.exceptions.ResourceNotFoundException;
import com.gamezone.model.Customer;
import com.gamezone.model.Seller;
import com.gamezone.model.Shift;
import com.gamezone.service.CustomerService;
import com.gamezone.service.SellerService;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for registering customers and listing customers/sellers.
 *
 * @author jahdiel
 */
public class PersonPanel extends JPanel {

    private CustomerService customerService = new CustomerService();
    private SellerService sellerService = new SellerService();

    private JTextField txtEmail, txtName, txtId, txtContact;
    private JTable customerTable, sellerTable;
    private DefaultTableModel customerTableModel, sellerTableModel;

    public PersonPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Clientes", createCustomerTab());
        tabs.addTab("Vendedores", createSellerTab());

        add(tabs, BorderLayout.CENTER);
    }

    private JPanel createCustomerTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(2, 4, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Registrar cliente"));

        txtEmail = new JTextField();
        txtName = new JTextField();
        txtId = new JTextField();
        txtContact = new JTextField();

        form.add(new JLabel("Email:"));
        form.add(txtEmail);
        form.add(new JLabel("Nombre:"));
        form.add(txtName);
        form.add(new JLabel("ID:"));
        form.add(txtId);
        form.add(new JLabel("Contacto:"));
        form.add(txtContact);

        JButton btnRegister = new JButton("Registrar cliente");
        btnRegister.addActionListener(e -> registerCustomer());

        JPanel formWrapper = new JPanel(new BorderLayout());
        formWrapper.add(form, BorderLayout.CENTER);
        formWrapper.add(btnRegister, BorderLayout.SOUTH);

        customerTableModel = new DefaultTableModel(
                new String[]{"ID", "Nombre", "Email", "Contacto"}, 0);
        customerTable = new JTable(customerTableModel);

        panel.add(formWrapper, BorderLayout.NORTH);
        panel.add(new JScrollPane(customerTable), BorderLayout.CENTER);

        refreshCustomerTable();
        return panel;
    }

    private JPanel createSellerTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        sellerTableModel = new DefaultTableModel(
                new String[]{"Código", "Nombre", "Turno", "ID", "Contacto"}, 0);
        sellerTable = new JTable(sellerTableModel);

        JButton btnRefresh = new JButton("Actualizar lista");
        btnRefresh.addActionListener(e -> refreshSellerTable());

        panel.add(btnRefresh, BorderLayout.NORTH);
        panel.add(new JScrollPane(sellerTable), BorderLayout.CENTER);

        refreshSellerTable();
        return panel;
    }

    private void registerCustomer() {
        try {
            String email = txtEmail.getText();
            String name = txtName.getText();
            long id = Long.parseLong(txtId.getText());
            long contact = Long.parseLong(txtContact.getText());

            customerService.registerCustomer(email, name, id, contact);
            JOptionPane.showMessageDialog(this, "Cliente registrado con éxito.");
            refreshCustomerTable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID y contacto deben ser números válidos.");
        } catch (ResourceNotFoundException e) {
            JOptionPane.showMessageDialog(this, "No se encontró el recurso solicitado: " + e.getMessage());
        } catch (BusinessRuleException e) {
            JOptionPane.showMessageDialog(this, "No se puede completar la operación: " + e.getMessage());
        } catch (InvalidDataException e) {
            JOptionPane.showMessageDialog(this, "Los datos ingresados no son válidos: " + e.getMessage());
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un problema al acceder a los datos del sistema. Contacte al administrador.");
        }
    }

    private void refreshCustomerTable() {
        customerTableModel.setRowCount(0);
        try {
            ArrayList<Customer> customers = customerService.listCustomers();
            for (Customer c : customers) {
                customerTableModel.addRow(new Object[]{
                        c.getiD(), c.getName(), c.geteMail(), c.getContactNumber()
                });
            }
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un problema al acceder a los datos del sistema. Contacte al administrador.");
        }
    }

    private void refreshSellerTable() {
        sellerTableModel.setRowCount(0);
        try {
            ArrayList<Seller> sellers = sellerService.listSellers();
            for (Seller s : sellers) {
                sellerTableModel.addRow(new Object[]{
                        s.getEmployeeCode(), s.getName(), s.getShift(), s.getiD(), s.getContactNumber()
                });
            }
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un problema al acceder a los datos del sistema. Contacte al administrador.");
        }
    }
}