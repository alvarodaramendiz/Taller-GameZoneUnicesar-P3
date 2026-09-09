package com.gamezone.ui;

import com.gamezone.model.Console;
import com.gamezone.model.Product;
import com.gamezone.model.VideoGame;
import com.gamezone.service.ProductService;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for registering and listing products (video games and consoles).
 *
 * @author jahdiel
 */
public class ProductPanel extends JPanel {

    private ProductService productService = new ProductService();

    private JTextField txtId, txtTitle, txtPrice, txtStock, txtAttr1, txtAttr2, txtAttr3;
    private JComboBox<String> comboType;
    private JTable table;
    private DefaultTableModel tableModel;

    public ProductPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(createFormPanel(), BorderLayout.NORTH);
        add(createTablePanel(), BorderLayout.CENTER);

        refreshTable();
    }

    private JPanel createFormPanel() {
        JPanel form = new JPanel(new GridLayout(4, 4, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Registrar producto"));

        comboType = new JComboBox<>(new String[]{"VideoGame", "Console"});
        txtId = new JTextField();
        txtTitle = new JTextField();
        txtPrice = new JTextField();
        txtStock = new JTextField();
        txtAttr1 = new JTextField(); // platform / brand
        txtAttr2 = new JTextField(); // genre / model
        txtAttr3 = new JTextField(); // ageRating / generation

        form.add(new JLabel("Tipo:"));
        form.add(comboType);
        form.add(new JLabel("ID:"));
        form.add(txtId);

        form.add(new JLabel("Título:"));
        form.add(txtTitle);
        form.add(new JLabel("Precio:"));
        form.add(txtPrice);

        form.add(new JLabel("Stock:"));
        form.add(txtStock);
        form.add(new JLabel("Platform/Brand:"));
        form.add(txtAttr1);

        form.add(new JLabel("Genre/Model:"));
        form.add(txtAttr2);
        form.add(new JLabel("AgeRating/Generation:"));
        form.add(txtAttr3);

        JButton btnRegister = new JButton("Registrar");
        btnRegister.addActionListener(e -> registerProduct());
        form.add(btnRegister);

        return form;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Inventario de productos"));

        tableModel = new DefaultTableModel(
                new String[]{"ID", "Título", "Precio", "Stock", "Descripción"}, 0);
        table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }

    private void registerProduct() {
        try {
            String id = txtId.getText();
            String title = txtTitle.getText();
            double price = Double.parseDouble(txtPrice.getText());
            int stock = Integer.parseInt(txtStock.getText());
            String result;

            if (comboType.getSelectedItem().equals("VideoGame")) {
                VideoGame vg = new VideoGame(txtAttr1.getText(), txtAttr2.getText(),
                        txtAttr3.getText(), id, title, price, stock);
                result = productService.registerVideoGame(vg);
            } else {
                Console console = new Console(txtAttr1.getText(), txtAttr2.getText(),
                        txtAttr3.getText(), id, title, price, stock);
                result = productService.registerConsole(console);
            }

            JOptionPane.showMessageDialog(this, result);
            refreshTable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio y stock deben ser números válidos.");
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        List<Product> products = productService.listProducts();
        for (Product p : products) {
            tableModel.addRow(new Object[]{
                    p.getProductId(), p.getTitle(), p.getPrice(), p.getStock(), p.getDescription()
            });
        }
    }
}