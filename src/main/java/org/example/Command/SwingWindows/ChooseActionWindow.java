package org.example.Command.SwingWindows;

import org.example.Command.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseActionWindow {
    private JFrame jFrame;
    private JPanel contentPanel;
    private JButton showProductsJButton;
    private JButton addProductsJButton;
    private JButton editProductsJButton;
    private JButton deleteProductsJButton;
    private Button showProductsButton;
    private Button addProductsButton;
    private Button editProductsButton;
    private Button deleteProductsButton;
    public ChooseActionWindow() {
        showProductsButton = new Button(new ShowProductsCommand());
        addProductsButton = new Button(new AddProductsCommand());
        editProductsButton = new Button(new EditProductsCommand());
        deleteProductsButton = new Button(new DeleteProductsCommand());
        jFrame = new JFrame("Product Management System");
        jFrame.setContentPane(contentPanel);
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        showProductsJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProductsButton.pushButton();
            }
        });
        addProductsJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductsButton.pushButton();
            }
        });
        editProductsJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProductsButton.pushButton();
            }
        });
        deleteProductsJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProductsButton.pushButton();
            }
        });
    }
}
