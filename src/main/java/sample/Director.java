package sample;

public class Director {
    private String name;

    private Company comp = new Company();

    Director() {
        name = "0";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createCompany(int money, int plan, String name) {
        comp.setMoney(money);
        comp.setPlan(plan);
        comp.setName(name);
    }

    public void changeCompanyName(String name) {
        comp.setName(name);
    }

    public void changeCompanyPlan(int plan) {
        comp.setPlan(plan);
    }

    public Company getComp() {
        return comp;
    }

    public String getName() {
        return name;
    }
}
