/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author msi1
 */
public class EditAccountDataStage extends Stage{
     public EditAccountDataStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editAccountData.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.setTitle("Edit Account Data Page");
        this.setScene(scene);
    }
    
}
