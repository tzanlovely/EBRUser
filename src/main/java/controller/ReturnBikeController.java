package controller;

import View.ReturnBikeListPane;
import View.ReturnBikeSinglePane;
import api.API;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class ReturnBikeController {
    private ReturnBikeListPane listPane;
    private List<ReturnBikeSinglePane> list;
    private API api = new API();


    public ReturnBikeController() {
        list = new ArrayList<ReturnBikeSinglePane>();
        listPane = new ReturnBikeListPane();
        listPane.setController(this);
        listPane.updateData(api.getListOrder());

        new Thread(() -> {
            while (true)
            {
                try {
                    Thread.sleep(1000);
                    for (ReturnBikeSinglePane singlePane : list) {
                        singlePane.updateData(singlePane.getOrder());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public ReturnBikeSinglePane createSinglePane(Order order) {
        ReturnBikeSinglePane returnBikeSinglePane = new ReturnBikeSinglePane(order);
        
        list.add(returnBikeSinglePane);
        return returnBikeSinglePane;
    }
    public void returnBike(Order order) {

    }

    public ReturnBikeListPane getListPane() {
        return listPane;
    }
}
