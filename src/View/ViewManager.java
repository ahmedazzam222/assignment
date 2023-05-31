/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AccountsJpaController;
import Controller.editAccountDataController;
import Model.Accounts;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author msi1
 */
public class ViewManager {

    public static AccountsManagementStage accountsManagementStage;
    public static AddNewAccountStage addNewAccountStage;
    public static EditAccountDataStage editAccountDataStage;
    private static AccountsJpaController accountsController;

    public static void setAccountsController(AccountsJpaController controller) {
        accountsController = controller;
    }

    public static void openAccountsManagementStage() throws IOException {
        if (accountsManagementStage == null) {
            accountsManagementStage = new AccountsManagementStage();
            accountsManagementStage.show();
        } else {
            accountsManagementStage.show();
        }
    }

    public static void closeAccountsManagementStage() {
        if (accountsManagementStage != null) {
            accountsManagementStage.close();
        }
    }

    public static void openAddNewAccountStage() throws IOException {
        if (addNewAccountStage == null) {
            addNewAccountStage = new AddNewAccountStage();
            addNewAccountStage.show();
        } else {
            addNewAccountStage.show();
        }
    }

    public static void closeAddNewAccountStage() {
        if (addNewAccountStage != null) {
            addNewAccountStage.close();
        }
    }

     public static void openEditAccountDataStage(Accounts selectedAccount) throws IOException {
        FXMLLoader loader = new FXMLLoader(ViewManager.class.getResource("editAccountData.fxml"));
        Parent root = loader.load();
        editAccountDataController controller = loader.getController();

        // Pass the selected account data to the editAccountDataController
        controller.setAccountData(selectedAccount);

        // Open the stage for editing
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
         stage.show();
    }


    public static void closeEditAccountDataStage() {
        if (editAccountDataStage != null) {
            editAccountDataStage.close();
        }
    }

}
