package sample;

import java.util.Date;

public class QuickOrder extends Order {
    private long delivery_time;


    QuickOrder(int number, String subject, int amount) {
        super(number, subject, amount);
        Date date = new Date();
        delivery_time = date.getTime() + 86400000;
    }

    public long checkTime() {
        Date date = new Date();
        return (delivery_time - date.getTime()) / 1000;
    }
}
