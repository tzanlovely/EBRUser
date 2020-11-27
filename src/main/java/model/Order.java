package model;

import java.util.Date;

public class Order {
    private int rentBikeParkID;
    private int bikeID;
    private Date checkin;
    private Date checkout;
    private int returnBikePark;

    public int getRentBikeParkID() {
        return rentBikeParkID;
    }

    public void setRentBikeParkID(int rentBikeParkID) {
        this.rentBikeParkID = rentBikeParkID;
    }

    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public int getReturnBikePark() {
        return returnBikePark;
    }

    public void setReturnBikePark(int returnBikePark) {
        this.returnBikePark = returnBikePark;
    }
}
