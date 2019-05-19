package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observable;

public class Client {
    private String name;
    private int money;
    private int maxAmount;
    private int discount;

    private Company comp = new Company();

    Client() {
        name = "0";
        money = 0;
        maxAmount = 10;
    }

    public ObservableList<OrderCart> getCartList() {
        ObservableList<OrderCart> list = FXCollections.observableArrayList();
        Class cls;
        for (int i = 0; i < comp.getOrderList().size(); i++) {
            cls = comp.getOrderList().get(i).getClass();
            if (this.name.equals(comp.getClient_list().get(i))) {
                if (cls == sample.Order.class) {
                    OrderCart order = new OrderCart((Order) comp.getOrderList().get(i));
                    order.setName(name);
                    list.add(order);
                } else {
                    OrderCart order = new OrderCart((QuickOrder) comp.getOrderList().get(i));
                    order.setName(name);
                    list.add(order);
                }
            }
        }
        return list;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int _maxAmount) {
        maxAmount = _maxAmount;
    }

    public void setName(String _name) {
        name = _name;
    }

    public void setMoney(int _money) {
        money = _money;
    }

    public int getMoney() {
        return money;
    }

    public void setComp(Company comp) {
        this.comp = comp;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public Company getComp() {
        return comp;
    }

    public String getName() {
        return name;
    }

    public void make_order(String name, int Amount) {
        comp.create_order(name, Amount, this.name);
    }

    public void make_quick_order(String name, int Amount) {
        comp.create_quick_order(name, Amount, this.name);
    }

    public void PayOrder() {
        if ((((Order) comp.getOrderList().get(comp.getOrderList().size() - 1)).get_amount() * (100 - discount)) > money)
            throw new IllegalArgumentException("Client don't have enough money");
        else {
            money -= ((Order) comp.getOrderList().get(comp.getOrderList().size() - 1)).get_amount() * (100 - discount);
            comp.perform_order(((Order) comp.getOrderList().get(comp.getOrderList().size() - 1)).get_amount() * (100 - discount));
        }
    }

}