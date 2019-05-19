package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {
    private View view = new View();
    private Model model = new Model();

    public void setGridPane() {
        view.setCreateCompanyGrid();
    }

    EventHandler<ActionEvent> MakeOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.makeOrder(view);
            view.setCreateOrderEvent(CreateSimpleOrderEvent);
        }
    };

    EventHandler<ActionEvent> CancelOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.cancelOrder(view);
        }
    };

    EventHandler<ActionEvent> ExitEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Platform.exit();
        }
    };

    EventHandler<ActionEvent> PhysicalEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.physicalOrder(view);
        }
    };

    EventHandler<ActionEvent> UridicalEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.uridicalOrder(view);
        }
    };

    EventHandler<ActionEvent> VIPEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.vipOrder(view);
        }
    };

    EventHandler<ActionEvent> CreateSimpleOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.createOrder(view);
        }
    };

    EventHandler<ActionEvent> CreateQuickOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.createQuickOrder(view);
        }
    };

    EventHandler<ActionEvent> SimpleOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            view.setCreateOrderEvent(CreateSimpleOrderEvent);
        }
    };

    EventHandler<ActionEvent> QuickOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            view.setCreateOrderEvent(CreateQuickOrderEvent);
        }
    };

    EventHandler<ActionEvent> PayOrderEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.payOrder(view);
        }
    };

    EventHandler<ActionEvent> CreateCompanyEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.createCompany(view);
        }
    };

    EventHandler<ActionEvent> LoginEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.clientLogin(view);
        }
    };

    EventHandler<ActionEvent> EditEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.editCompany(view);
        }
    };

    EventHandler<ActionEvent> DirectorLoginEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            view.setNextEvent(EditEvent);
        }
    };

    EventHandler<ActionEvent> ClientLoginEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            view.setNextEvent(LoginEvent);
        }
    };

    EventHandler<ActionEvent> BackEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.Back(view);
            view.setNextEvent(LoginEvent);
        }
    };

    EventHandler<ActionEvent> SaveEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.Save(view);
            view.setNextEvent(LoginEvent);
        }
    };

    EventHandler<ActionEvent> CartEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            model.showCart(view);
        }
    };

    public Controller() {
        view.setMakeOrderEvent(MakeOrderEvent);
        view.setCreateOrderEvent(CreateSimpleOrderEvent);
        view.setPayOrderEvent(PayOrderEvent);
        view.setExitEvent(ExitEvent);
        view.setCancelOrderEvent(CancelOrderEvent);
        view.setPhysicalOrderEvent(PhysicalEvent);
        view.setUridicalOrderEvent(UridicalEvent);
        view.setCreateCompanyEvent(CreateCompanyEvent);
        view.setDirectorEvent(DirectorLoginEvent);
        view.setClientEvent(ClientLoginEvent);
        view.setNextEvent(LoginEvent);
        view.setBackEvent(BackEvent);
        view.setSaveEvent(SaveEvent);
        view.setCartEvent(CartEvent);
        view.setVIPOrderEvent(VIPEvent);
        view.setSimpleOrderEvent(SimpleOrderEvent);
        view.setQuickOrderEvent(QuickOrderEvent);
    }
}