package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountsManagementStage extends Stage {

    public AccountsManagementStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("accountsManagementSystemMain.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.setTitle("Accounts Management System");
        this.setScene(scene);
    }
}