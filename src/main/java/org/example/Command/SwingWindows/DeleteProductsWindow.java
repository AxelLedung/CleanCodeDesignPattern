package org.example.Command.SwingWindows;

import javax.swing.*;

public class DeleteProductsWindow {
    private JFrame jFrame;
    private JPanel contentPanel;
    private JList productList;
    private JButton backButton;
    public DeleteProductsWindow() {
        jFrame = new JFrame("Delete Products - Product Management System");
        jFrame.setContentPane(contentPanel);
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
