package FXMainApp;

import View.ViewManager;
import Controller.AccountsJpaController;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.application.Application;
import javafx.stage.Stage;

public class FXMainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        ViewManager.openAccountsManagementStage();

    }
}
