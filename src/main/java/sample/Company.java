package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Company {
    private int money;
    private int plan;
    private String name;
    private List<Object> order_list = new ArrayList<Object>();
    private List<String> client_list;
    private static int order_count;

    Company() {
        money = 0;
        plan = 0;
        name = "0";
        order_count = 0;
        order_list = new ArrayList<>();
        client_list = new ArrayList<>();
    }

    public void create_order(String name, int count, String client_name) {
        order_count++;
        Order newOrder = new Order(order_count, name, count);
        order_list.add(newOrder);
        client_list.add(client_name);
    }

    public void create_quick_order(String name, int count, String client_name) {
        order_count++;
        QuickOrder newOrder = new QuickOrder(order_count, name, count);
        order_list.add(newOrder);
        client_list.add(client_name);
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public int getPlan() {
        return plan;
    }

    public void cancel_order() {
        order_list.remove(0);
    }

    public List<Object> getOrderList() {
        return order_list;
    }

    public List<String> getClient_list() {
        return client_list;
    }

    public void perform_order(int earnings) {
        ((Order) order_list.get(order_list.size() - 1)).set_state(true);
        money += earnings;
        plan -= ((Order) order_list.get(order_list.size() - 1)).get_amount();
        if (plan < 0)
            plan = 0;
    }
}