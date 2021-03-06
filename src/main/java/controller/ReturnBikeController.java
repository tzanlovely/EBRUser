package controller;

import View.MainPanel;
import View.ReturnBikeListPane;
import View.ReturnBikeSinglePane;
import View.SearchPanel;
import api.API;
import model.Bike;
import model.Order;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ReturnBikeController {
    private ReturnBikeListPane listPane;
    private List<ReturnBikeSinglePane> listSinglePane;
    private API api = new API();
    private JPanel mainPanel;

    public ReturnBikeController() {
        listSinglePane = new ArrayList<ReturnBikeSinglePane>();
        listPane = new ReturnBikeListPane();
        listPane.setController(this);
        listPane.updateData(api.getListOrder());

        new Thread(() -> {
            while (true)
            {
                try {
                    Thread.sleep(1000);
                    for (ReturnBikeSinglePane singlePane : listSinglePane) {
                        singlePane.updateData(singlePane.getOrder());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public ReturnBikeSinglePane createSinglePane(Order order) {
        ReturnBikeSinglePane returnBikeSinglePane = new ReturnBikeSinglePane(order, getBike());
        
        listSinglePane.add(returnBikeSinglePane);
        return returnBikeSinglePane;
    }
    public void returnBike(Order order) {

    }

    public Bike getBike() {
        return api.getBike();
    }

    public JPanel getReturnBikePage() {

        return new MainPanel(new SearchPanel(), listPane);
    }
}
