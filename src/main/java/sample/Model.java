package sample;

public class Model {
    private Client client = new Client();
    private Director dir = new Director();

    public void physicalOrder(View view) {
        client.setMaxAmount(10);
        client.setDiscount(0);
        view.AmountLimitError(10);
    }

    public void uridicalOrder(View view) {
        client.setMaxAmount(1000);
        client.setDiscount(20);
        view.AmountLimitError(1000);
    }

    public void vipOrder(View view) {
        client.setMaxAmount(10000);
        client.setDiscount(40);
        view.AmountLimitError(10000);
    }

    public void createCompany(View view) {
        if (checkEmpty(view.getCompanyName()) && checkNumeric(view.getCompanyMoney()) && checkNumeric(view.getCompanyPlan()) && checkEmpty(view.getDirecterName())) {
            dir.createCompany(Integer.parseInt(view.getCompanyMoney()), Integer.parseInt(view.getCompanyPlan()), view.getCompanyName());
            dir.setName(view.getDirecterName());
            view.choozePersonGrid(dir.getComp());
        } else {
            if (!checkEmpty(view.getCompanyName())) {
                view.companyNameErr();
                throw new IllegalArgumentException("Company name is empty");
            }
            if (!checkNumeric(view.getCompanyMoney())) {
                view.companyMoneyErr();
                throw new IllegalArgumentException("Money is not a number");
            }
            if (!checkEmpty(view.getDirecterName())) {
                view.directerNameErr();
                throw new IllegalArgumentException("Director name is empty");
            }
            if (!checkNumeric(view.getCompanyPlan())) {
                view.companyPlanErr();
                throw new IllegalArgumentException("Company plan is not a number");
            }
        }
    }

    public void createOrder(View view) {
        if (checkEmpty(view.getOrderName()) && checkNumeric(view.getOrderAmount())) {
            if (Integer.parseInt(view.getOrderAmount()) <= client.getMaxAmount()) {
                client.setComp(dir.getComp());
                client.make_order(view.getOrderName(), Integer.parseInt(view.getOrderAmount()));
                view.setPayGrid(client);
            } else {
                view.AmountLimitError(client.getMaxAmount());
                throw new IllegalArgumentException("Maximum number of subjects exceeded");
            }
        } else {
            if (!checkEmpty(view.getOrderName())) {
                view.subjectErr();
                throw new IllegalArgumentException("Subject name is empty");
            }
            if (!checkNumeric(view.getOrderAmount())) {
                view.amountErr();
                throw new IllegalArgumentException("Number of subjects is not a number");
            }
        }
    }

    public void createQuickOrder(View view) {
        if (checkEmpty(view.getOrderName()) && checkNumeric(view.getOrderAmount())) {
            if (Integer.parseInt(view.getOrderAmount()) <= client.getMaxAmount()) {
                client.setComp(dir.getComp());
                client.make_quick_order(view.getOrderName(), Integer.parseInt(view.getOrderAmount()));
                view.setPayGrid(client);
            } else
                view.AmountLimitError(client.getMaxAmount());
        } else {
            if (!checkEmpty(view.getOrderName())) {
                view.subjectErr();
                throw new IllegalArgumentException("Subject name is empty");
            }
            if (!checkNumeric(view.getOrderAmount())) {
                view.amountErr();
                throw new IllegalArgumentException("Number of subjects not a number");
            }
        }
    }

    public void makeOrder(View view) {
        if (checkEmpty(view.getName()) && checkNumeric(view.getMoney())) {
            client.setName(view.getName());
            client.setMoney(Integer.parseInt(view.getMoney()));
            view.createOrderGrid();
        } else {
            if (!checkEmpty(view.getName())) {
                view.nameErr();
                throw new IllegalArgumentException("Client name is empty");
            }
            if (!checkNumeric(view.getMoney())) {
                view.moneyErr();
                throw new IllegalArgumentException("Client money is not a number");
            }
        }
    }

    public void payOrder(View view) {
        client.PayOrder();
        view.setOrderGrid(client);
    }

    public void cancelOrder(View view) {
        view.setOrderGrid(client);
    }

    public void editCompany(View view) {
        view.editCompanyGrid(dir.getComp());
    }

    public void showCart(View view) {
        view.showCart(client);
    }

    public void clientLogin(View view) {
        view.setStartGrid();
    }

    public void Back(View view) {
        view.choozePersonGrid(dir.getComp());
    }

    public void Save(View view) {
        if (checkEmpty(view.getCompanyName()) && checkNumeric(view.getCompanyPlan())) {
            dir.changeCompanyName(view.getCompanyName());
            dir.changeCompanyPlan(Integer.parseInt(view.getCompanyPlan()));
            view.choozePersonGrid(dir.getComp());
        } else {
            if (!checkEmpty(view.getCompanyName())) {
                view.companyNameErr();
                throw new IllegalArgumentException("Name is empty");
            }
            if (!checkNumeric(view.getCompanyPlan())) {
                view.companyPlanErr();
                throw new IllegalArgumentException("Not a number");
            }

        }
    }

    public boolean checkNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkEmpty(String str) {
        if (str.trim().length() > 0)
            return true;
        else
            return false;
    }
}