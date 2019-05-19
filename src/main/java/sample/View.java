package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class View {
    private Stage stage = new Stage();
    private Class cls = sample.Order.class;
    private ToggleGroup group = new ToggleGroup();

    private TextField order_subject = new TextField();
    private TextField order_amount = new TextField();
    private TextField name = new TextField();
    private TextField money = new TextField();
    private TextField comp_name = new TextField();
    private TextField comp_money = new TextField();
    private TextField comp_plan = new TextField();
    private TextField dir_name = new TextField();

    private Button next_btn = new Button("Next");
    private Button save_btn = new Button("Save");
    private Button back_btn = new Button("Back");
    private Button create_btn = new Button("Create order");
    private Button pay_btn = new Button("Pay");
    private Button cancel_btn = new Button("Cancel");
    private Button cart_btn = new Button("Cart");
    private Button make_order = new Button("Make order");
    private Button exit = new Button("Exit");
    private Button create_comp_btn = new Button("Create Company");

    private RadioButton simple_order = new RadioButton("Simple order");
    private RadioButton quick_order_btn = new RadioButton("Quick order");
    private RadioButton phys_btn = new RadioButton("Physical");
    private RadioButton urid_btn = new RadioButton("Uridistic");
    private RadioButton vip_btn = new RadioButton("VIP");
    private RadioButton director_btn = new RadioButton("Director");
    private RadioButton client_btn = new RadioButton("Client");

    private Label subject_lbl = new Label("subject: ");
    private Label amount_lbl = new Label("amount: ");
    private Label order_state_lbl = new Label();
    private Label order_lbl = new Label("Current order");
    private Label number_lbl = new Label();
    private Label payment_amount_lbl = new Label();
    private Label name_lbl = new Label("Name");
    private Label money_lbl = new Label("Balance");
    private Label comp_name_lbl = new Label("Company name:");
    private Label comp_money_lbl = new Label("Company money:");
    private Label comp_plan_lbl = new Label("Company plan:");
    private Label dir_name_lbl = new Label("Directer's name:");
    private Label login_method_lbl = new Label("Select login method");

    public void setGap(GridPane gridPane) {
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
    }

    public void setCreateCompanyGrid() {
        stage.setTitle("lab3");
        GridPane grid = new GridPane();
        stage.setWidth(300);
        stage.setHeight(245);
        setGap(grid);

        GridPane.setHalignment(comp_name_lbl, HPos.LEFT);
        grid.add(comp_name_lbl, 0, 0);

        GridPane.setHalignment(comp_name, HPos.LEFT);
        grid.add(comp_name, 1, 0);

        GridPane.setHalignment(comp_money_lbl, HPos.LEFT);
        grid.add(comp_money_lbl, 0, 1);

        GridPane.setHalignment(comp_money, HPos.LEFT);
        grid.add(comp_money, 1, 1);

        GridPane.setHalignment(comp_plan_lbl, HPos.LEFT);
        grid.add(comp_plan_lbl, 0, 2);

        GridPane.setHalignment(comp_plan, HPos.LEFT);
        grid.add(comp_plan, 1, 2);

        GridPane.setHalignment(dir_name_lbl, HPos.LEFT);
        grid.add(dir_name_lbl, 0, 3);

        GridPane.setHalignment(dir_name, HPos.LEFT);
        grid.add(dir_name, 1, 3);

        GridPane.setHalignment(create_comp_btn, HPos.CENTER);
        grid.add(create_comp_btn, 0, 4, 2, 1);

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public void choozePersonGrid(Company comp) {
        GridPane grid = new GridPane();
        stage.setWidth(300);
        stage.setHeight(150);
        setGap(grid);

        comp_name_lbl.setText("Company: " + comp.getName());
        GridPane.setHalignment(comp_name_lbl, HPos.LEFT);
        grid.add(comp_name_lbl, 0, 0);

        comp_plan_lbl.setText("Plan: " + comp.getPlan());
        GridPane.setHalignment(comp_plan_lbl, HPos.LEFT);
        grid.add(comp_plan_lbl, 1, 0);

        comp_money_lbl.setText("Money: " + comp.getMoney());
        GridPane.setHalignment(comp_money_lbl, HPos.LEFT);
        grid.add(comp_money_lbl, 2, 0);

        GridPane.setHalignment(login_method_lbl, HPos.CENTER);
        grid.add(login_method_lbl, 0, 1);

        GridPane.setHalignment(client_btn, HPos.CENTER);
        grid.add(client_btn, 1, 1);
        client_btn.setToggleGroup(group);
        client_btn.setSelected(true);

        GridPane.setHalignment(director_btn, HPos.CENTER);
        grid.add(director_btn, 2, 1);
        director_btn.setToggleGroup(group);

        GridPane.setHalignment(next_btn, HPos.CENTER);
        grid.add(next_btn, 0, 2, 2, 1);
        next_btn.setPrefWidth(100);

        GridPane.setHalignment(exit, HPos.CENTER);
        grid.add(exit, 2, 2);
        exit.setPrefWidth(50);

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public void editCompanyGrid(Company comp) {
        GridPane grid = new GridPane();
        stage.setWidth(300);
        stage.setHeight(165);
        setGap(grid);

        comp_name_lbl.setText("Company: ");
        GridPane.setHalignment(comp_name_lbl, HPos.LEFT);
        grid.add(comp_name_lbl, 0, 0);

        comp_name.setText(comp.getName());
        GridPane.setHalignment(comp_name, HPos.LEFT);
        grid.add(comp_name, 1, 0);

        comp_plan_lbl.setText("Plan: ");
        GridPane.setHalignment(comp_plan_lbl, HPos.LEFT);
        grid.add(comp_plan_lbl, 0, 1);

        comp_plan.setText(String.valueOf(comp.getPlan()));
        GridPane.setHalignment(comp_plan, HPos.LEFT);
        grid.add(comp_plan, 1, 1);

        GridPane.setHalignment(save_btn, HPos.CENTER);
        grid.add(save_btn, 0, 2);

        GridPane.setHalignment(back_btn, HPos.CENTER);
        grid.add(back_btn, 1, 2);

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public void setStartGrid() {
        GridPane grid = new GridPane();
        stage.setWidth(250);
        stage.setHeight(195);
        setGap(grid);

        GridPane.setHalignment(phys_btn, HPos.LEFT);
        grid.add(phys_btn, 0, 0);
        phys_btn.setToggleGroup(group);
        phys_btn.setSelected(true);

        GridPane.setHalignment(urid_btn, HPos.LEFT);
        grid.add(urid_btn, 1, 0);
        urid_btn.setToggleGroup(group);

        GridPane.setHalignment(vip_btn, HPos.LEFT);
        grid.add(vip_btn, 2, 0);
        vip_btn.setToggleGroup(group);


        name_lbl.setText("Name");
        GridPane.setHalignment(name_lbl, HPos.LEFT);
        grid.add(name_lbl, 0, 1);

        GridPane.setHalignment(name, HPos.LEFT);
        grid.add(name, 1, 1, 2, 1);

        money_lbl.setText("Balance");
        GridPane.setHalignment(money_lbl, HPos.LEFT);
        grid.add(money_lbl, 0, 2);

        GridPane.setHalignment(money, HPos.LEFT);
        grid.add(money, 1, 2, 2, 1);

        GridPane.setHalignment(make_order, HPos.CENTER);
        grid.add(make_order, 0, 3, 2, 1);

        GridPane.setHalignment(exit, HPos.CENTER);
        grid.add(back_btn, 2, 3);

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public void createOrderGrid() {
        GridPane grid = new GridPane();
        stage.setWidth(300);
        stage.setHeight(195);
        setGap(grid);

        order_subject.clear();
        order_amount.clear();

        subject_lbl.setText("subject: ");
        GridPane.setHalignment(subject_lbl, HPos.LEFT);
        grid.add(subject_lbl, 0, 0);

        order_subject.setPromptText("");
        GridPane.setHalignment(order_subject, HPos.LEFT);
        grid.add(order_subject, 1, 0);

        amount_lbl.setText("amount: ");
        GridPane.setHalignment(amount_lbl, HPos.LEFT);
        grid.add(amount_lbl, 0, 1);

        order_amount.setPromptText("");
        GridPane.setHalignment(order_amount, HPos.LEFT);
        grid.add(order_amount, 1, 1);

        GridPane.setHalignment(simple_order, HPos.LEFT);
        grid.add(simple_order, 0, 2);
        simple_order.setToggleGroup(group);
        simple_order.setSelected(true);

        GridPane.setHalignment(quick_order_btn, HPos.LEFT);
        grid.add(quick_order_btn, 1, 2);
        quick_order_btn.setToggleGroup(group);

        GridPane.setHalignment(create_btn, HPos.CENTER);
        grid.add(create_btn, 0, 3);

        GridPane.setHalignment(back_btn, HPos.CENTER);
        grid.add(back_btn, 1, 3);

        stage.setScene(new Scene(grid));
        stage.show();
    }

    public void setPayGrid(Client client) {
        GridPane grid = new GridPane();
        stage.setWidth(270);
        stage.setHeight(140);
        grid.setHgap(15);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 10, 10));
        cls = client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1).getClass();

        GridPane.setHalignment(order_lbl, HPos.LEFT);
        grid.add(order_lbl, 0, 0);

        if (cls.equals(sample.Order.class)) {
            number_lbl.setText("number: " + ((Order) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_number());
            GridPane.setHalignment(number_lbl, HPos.LEFT);
            grid.add(number_lbl, 0, 1);

            subject_lbl.setText("subject: " + ((Order) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_subject());
            GridPane.setHalignment(subject_lbl, HPos.LEFT);
            grid.add(subject_lbl, 0, 2);

            amount_lbl.setText("amount: " + ((Order) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_amount());
            GridPane.setHalignment(amount_lbl, HPos.LEFT);
            grid.add(amount_lbl, 0, 3);

            payment_amount_lbl.setText("Payment amount: " + ((Order) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_amount() * (100 - client.getDiscount()));
            GridPane.setHalignment(payment_amount_lbl, HPos.LEFT);
            grid.add(payment_amount_lbl, 1, 1, 2, 1);
        } else {
            number_lbl.setText("number: " + ((QuickOrder) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_number());
            GridPane.setHalignment(number_lbl, HPos.LEFT);
            grid.add(number_lbl, 0, 1);

            subject_lbl.setText("subject: " + ((QuickOrder) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_subject());
            GridPane.setHalignment(subject_lbl, HPos.LEFT);
            grid.add(subject_lbl, 0, 2);

            amount_lbl.setText("amount: " + ((QuickOrder) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_amount());
            GridPane.setHalignment(amount_lbl, HPos.LEFT);
            grid.add(amount_lbl, 0, 3);

            payment_amount_lbl.setText("Payment amount: " + ((QuickOrder) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_amount() * (100 - client.getDiscount()));
            GridPane.setHalignment(payment_amount_lbl, HPos.LEFT);
            grid.add(payment_amount_lbl, 1, 1, 2, 1);
        }

        pay_btn.setPrefWidth(65);
        GridPane.setHalignment(pay_btn, HPos.RIGHT);
        grid.add(pay_btn, 1, 2, 1, 2);

        cancel_btn.setPrefWidth(65);
        GridPane.setHalignment(cancel_btn, HPos.RIGHT);
        grid.add(cancel_btn, 2, 2, 1, 2);

        stage.setScene(new Scene(grid));
        stage.show();
    }

    public void setOrderGrid(Client client) {
        GridPane grid = new GridPane();
        stage.setWidth(250);
        stage.setHeight(150);
        setGap(grid);

        cls = client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1).getClass();
        if (cls.equals(sample.Order.class)) {
            if (((Order) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_state() == true) {
                order_state_lbl.setStyle("-fx-text-fill: green;");
                order_state_lbl.setText("Order completed!");
            } else {
                order_state_lbl.setStyle("-fx-text-fill: red;");
                order_state_lbl.setText("Order cancelled!");
            }
        } else {
            if (((QuickOrder) client.getComp().getOrderList().get(client.getComp().getOrderList().size() - 1)).get_state() == true) {
                order_state_lbl.setStyle("-fx-text-fill: green;");
                order_state_lbl.setText("Order completed!");
            } else {
                order_state_lbl.setStyle("-fx-text-fill: red;");
                order_state_lbl.setText("Order cancelled!");
            }
        }

        GridPane.setHalignment(order_state_lbl, HPos.LEFT);
        grid.add(order_state_lbl, 0, 0, 3, 1);

        name_lbl.setText("Name: " + client.getName());
        GridPane.setHalignment(name_lbl, HPos.LEFT);
        grid.add(name_lbl, 0, 1);

        money_lbl.setText("Balance: " + client.getMoney());
        GridPane.setHalignment(money_lbl, HPos.CENTER);
        grid.add(money_lbl, 1, 1, 2, 1);

        GridPane.setHalignment(make_order, HPos.LEFT);
        grid.add(make_order, 0, 2, 1, 1);

        GridPane.setHalignment(cart_btn, HPos.LEFT);
        grid.add(cart_btn, 1, 2);

        GridPane.setHalignment(back_btn, HPos.LEFT);
        grid.add(back_btn, 2, 2);


        stage.setScene(new Scene(grid));
        stage.show();
    }

    public void showCart(Client client) {
        TableView<OrderCart> table = new TableView<>();

        Scene secondScene = new Scene(table);

        ObservableList<OrderCart> list = client.getCartList();

        TableColumn<OrderCart, String> clientNameCol = new TableColumn<OrderCart, String>("Client Name");
        TableColumn<OrderCart, String> subjectNameCol = new TableColumn<OrderCart, String>("Subject Name");
        TableColumn<OrderCart, Integer> amountCol = new TableColumn<OrderCart, Integer>("Amount");
        TableColumn<OrderCart, String> stateCol = new TableColumn<OrderCart, String>("State");
        TableColumn<OrderCart, Integer> orderIdCol = new TableColumn<OrderCart, Integer>("Order Id");
        TableColumn<OrderCart, String> timeCol = new TableColumn<OrderCart, String>("Delivery Time");

        clientNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        subjectNameCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        stateCol.setCellValueFactory(new PropertyValueFactory<>("state"));
        orderIdCol.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        clientNameCol.setSortType(TableColumn.SortType.DESCENDING);

        table.setItems(list);

        table.getColumns().addAll(clientNameCol, orderIdCol, subjectNameCol, amountCol, stateCol, timeCol);

        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);

        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(stage);

        newWindow.setX(stage.getX() + 200);
        newWindow.setY(stage.getY() + 100);

        newWindow.show();
    }

    public void setDirectorEvent(EventHandler<ActionEvent> handle) {
        director_btn.setOnAction(handle);
    }

    public void setClientEvent(EventHandler<ActionEvent> handle) {
        client_btn.setOnAction(handle);
    }

    public void setNextEvent(EventHandler<ActionEvent> handle) {
        next_btn.setOnAction(handle);
    }

    public void setSaveEvent(EventHandler<ActionEvent> handle) {
        save_btn.setOnAction(handle);
    }

    public void setBackEvent(EventHandler<ActionEvent> handle) {
        back_btn.setOnAction(handle);
    }

    public void setCreateCompanyEvent(EventHandler<ActionEvent> handle) {
        create_comp_btn.setOnAction(handle);
    }

    public void setMakeOrderEvent(EventHandler<ActionEvent> handle) {
        make_order.setOnAction(handle);
    }

    public void setCreateOrderEvent(EventHandler<ActionEvent> handle) {
        create_btn.setOnAction(handle);
    }

    public void setPayOrderEvent(EventHandler<ActionEvent> handle) {
        pay_btn.setOnAction(handle);
    }

    public void setCancelOrderEvent(EventHandler<ActionEvent> handle) {
        cancel_btn.setOnAction(handle);
    }

    public void setPhysicalOrderEvent(EventHandler<ActionEvent> handle) {
        phys_btn.setOnAction(handle);
    }

    public void setUridicalOrderEvent(EventHandler<ActionEvent> handle) {
        urid_btn.setOnAction(handle);
    }

    public void setVIPOrderEvent(EventHandler<ActionEvent> handle) {
        vip_btn.setOnAction(handle);
    }

    public void setExitEvent(EventHandler<ActionEvent> handle) {
        exit.setOnAction(handle);
    }

    public void setCartEvent(EventHandler<ActionEvent> handle) {
        cart_btn.setOnAction(handle);
    }

    public void setSimpleOrderEvent(EventHandler<ActionEvent> handle) {
        simple_order.setOnAction(handle);
    }

    public void setQuickOrderEvent(EventHandler<ActionEvent> handle) {
        quick_order_btn.setOnAction(handle);
    }

    public String getCompanyName() {
        return comp_name.getText();
    }

    public String getCompanyMoney() {
        return comp_money.getText();
    }

    public String getCompanyPlan() {
        return comp_plan.getText();
    }

    public String getDirecterName() {
        return dir_name.getText();
    }

    public String getOrderName() {
        return order_subject.getText();
    }

    public String getOrderAmount() {
        return order_amount.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getMoney() {
        return money.getText();
    }

    public void companyNameErr() {
        comp_name.clear();
        comp_name.setPromptText("Name doesn't entered!");
    }

    public void companyMoneyErr() {
        comp_money.clear();
        comp_money.setPromptText("Incorrect digit!");
    }

    public void directerNameErr() {
        dir_name.clear();
        dir_name.setPromptText("Incorrect name entered!");
    }

    public void companyPlanErr() {
        comp_plan.clear();
        comp_plan.setPromptText("Incorrect digit!");
    }

    public void nameErr() {
        name.clear();
        name.setPromptText("Name doesn't entered!");
    }

    public void moneyErr() {
        money.clear();
        money.setPromptText("Incorrect digit!");
    }

    public void subjectErr() {
        order_subject.clear();
        order_subject.setPromptText("Subject doesn't entered!");
    }

    public void amountErr() {
        order_amount.clear();
        order_amount.setPromptText("Incorrect digit!");
    }

    public void AmountLimitError(int max) {
        order_amount.clear();
        order_amount.setPromptText("Max amount is " + max);
    }
}