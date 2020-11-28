package View;

import model.Bike;
import model.Order;
import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnBikeSinglePane extends JPanel {
    private JPanel panel;
    private Order order;
    private Bike bike;
    private JLabel bikeID;
    private JLabel checkin;
    private JLabel difference;
    private JLabel current;
    private JLabel amount;
    private GridBagLayout layout;
    private GridBagConstraints c;
    private long diffmilis;

    public ReturnBikeSinglePane(Order order, Bike bike) {
        this.order = order;
        this.bike = bike;
        buildControl();
        updateData(order);
    }

    private int getLastRowIndex() {
        layout.layoutContainer(this);
        int[][] dim = layout.getLayoutDimensions();
        int rows = dim[1].length;
        return rows;
    }

    public void buildControl() {
        layout = new GridBagLayout();
        this.setLayout(layout);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 1;

        int row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        bikeID = new JLabel();
        add(bikeID, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        checkin = new JLabel();
        add(checkin, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        difference = new JLabel();
        add(difference, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        current = new JLabel();
        add(current, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        amount = new JLabel();
        add(amount, c);
    }

    public void updateData(Order order) {
        this.order = order;
        bikeID.setText("Bike ID: "+order.getBikeID());
        checkin.setText("Checkin time: "+order.getCheckin().toString());
        difference.setText("Rented time: "+getDifference());
        current.setText("Current time: "+(new Date()).toString());
        amount.setText("Amount: "+calculateAmount());
    }

    public void addDataHandlingComponent(Component component) {
        if (panel == null) {
            int row = getLastRowIndex();
            c.gridx = 0;
            c.gridy = row;
            panel = new JPanel();
            this.add(panel, c);
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        }

        panel.add(component);
    }

    public Order getOrder() {
        return this.order;
    }

    private String getDifference() {
        Date current = new Date();
        this.current.setText(current.toString());
        diffmilis = Math.abs(current.getTime() - order.getCheckin().getTime());

        String formattedDuration = DurationFormatUtils.formatDuration(diffmilis,"HH:mm:ss");

        return formattedDuration;
    }

    private float calculateAmount() {
        float amount = 0f;

        amount = bike.getPrice()*diffmilis/100000;

        return  amount;
    }
}
