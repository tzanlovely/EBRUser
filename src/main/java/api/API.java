package api;

import model.Bike;
import model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class API {
    public List<Order> getListOrder() {
        List<Order> list = new ArrayList<Order>();

        Order order = new Order();
        order.setBikeID(100000);
        order.setCheckin(new Date());
        order.setCheckout(new Date());
        order.setRentBikeParkID(20000);
        order.setReturnBikePark(300000);
        list.add(order);

        order = new Order();
        order.setBikeID(500000);
        order.setCheckin(new Date());
        order.setCheckout(new Date());
        order.setRentBikeParkID(60000);
        order.setReturnBikePark(700000);
        list.add(order);

        order = new Order();
        order.setBikeID(500000);
        order.setCheckin(new Date());
        order.setCheckout(new Date());
        order.setRentBikeParkID(60000);
        order.setReturnBikePark(700000);
        list.add(order);

        order = new Order();
        order.setBikeID(500000);
        order.setCheckin(new Date());
        order.setCheckout(new Date());
        order.setRentBikeParkID(60000);
        order.setReturnBikePark(700000);
        list.add(order);

        order = new Order();
        order.setBikeID(500000);
        order.setCheckin(new Date());
        order.setCheckout(new Date());
        order.setRentBikeParkID(60000);
        order.setReturnBikePark(700000);
        list.add(order);

        order = new Order();
        order.setBikeID(500000);
        order.setCheckin(new Date());
        order.setCheckout(new Date());
        order.setRentBikeParkID(60000);
        order.setReturnBikePark(700000);
        list.add(order);

        return list;
    }

    public Bike getBike() {
        return new Bike();
    }
}
