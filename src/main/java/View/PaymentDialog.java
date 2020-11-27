package View;

import controller.ReturnBikeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentDialog extends JDialog {
    private JLabel viewNumber;
    private JLabel viewName;
    private JTextField number;
    private JTextField name;

    private GridBagLayout layout;
    private GridBagConstraints c;

    private ReturnBikeController controller;


    public PaymentDialog(ReturnBikeController controller) {
        super((Frame)null, "Payment", true);

        this.controller = controller;

        viewNumber = new JLabel("Account number: ");
        viewName = new JLabel("Your name: ");
        name = new JTextField(15);
        number = new JTextField(15);

        setContentPane(new JPanel());
        layout = new GridBagLayout();
        getContentPane().setLayout(layout);
        c = new GridBagConstraints();

        c.gridy = getLastRowIndex();
        c.gridx = 1;
        getContentPane().add(viewName, c);
        c.gridx = 2;
        getContentPane().add(name, c);


        c.gridy = getLastRowIndex();
        c.gridx = 1;
        getContentPane().add(viewNumber, c);
        c.gridx = 2;
        getContentPane().add(number, c);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentDialog.this.dispose();
            }
        });
        c.gridx = 1;
        c.gridy = getLastRowIndex();
        getContentPane().add(submitButton, c);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentDialog.this.dispose();
            }
        });
        c.gridx = 2;
        getContentPane().add(cancelButton, c);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private int getLastRowIndex() {
        layout.layoutContainer(getContentPane());
        int[][] dim = layout.getLayoutDimensions();

        int rows = dim[1].length;
        return rows;
    }
}
