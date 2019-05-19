package sample;

public class OrderCart {
    private String name;
    private String subject;
    private int amount;
    private String state;
    private int orderId;
    private String date;

    OrderCart(Order order) {
        subject = order.get_subject();
        amount = order.get_amount();
        if (order.get_state()) {
            state = "Completed";
            date = "~1 week";
        } else {
            state = "Cancelled";
            date = "-";
        }
        orderId = order.get_number();

    }

    OrderCart(QuickOrder quickOrder) {
        subject = quickOrder.get_subject();
        amount = quickOrder.get_amount();
        if (quickOrder.get_state()) {
            state = "Completed";
            checkOrderTime(quickOrder);
        } else {
            state = "Cancelled";
            date = "-";
        }
        orderId = quickOrder.get_number();
    }

    public void setName(String _name) {
        name = _name;
    }

    public void checkOrderTime(QuickOrder quickOrder) {
        long remainingTime = quickOrder.checkTime();
        int hours = (int) remainingTime / 3600, minutes = ((int) remainingTime - hours * 3600) / 60, seconds = (int) remainingTime % 60;
        date = hours + "h " + minutes + "m " + seconds + "s";
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public String isState() {
        return state;
    }
}
