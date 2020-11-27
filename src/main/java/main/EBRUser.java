package main;

import controller.ReturnBikeController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EBRUser extends JFrame {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 550;
    private ReturnBikeController controller;

    public EBRUser () {
        super("EBRUser control system");
        JPanel rootPanel = new JPanel();
        setContentPane(rootPanel);
        BorderLayout layout = new BorderLayout();
        rootPanel.setLayout(layout);
        rootPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        controller = new ReturnBikeController();
        add(controller.getListPane());

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EBRUser ebrUser = new EBRUser();
    }
}
