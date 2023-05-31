/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.exceptions.NonexistentEntityException;
import Model.Accounts;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author msi1
 */
public class AccountsManagementSystemMainController implements Initializable {

    @FXML
    private TableView<Accounts> tableViewAccounts;
    @FXML
    private TableColumn<Accounts, Integer> tableColumnID;
    @FXML
    private TableColumn<Accounts, Integer> tableColumnAccountNumber;
    @FXML
    private TableColumn<Accounts, String> tableColumnUserName;
    @FXML
    private TableColumn<Accounts, String> tableColumnCurrency;
    @FXML
    private TableColumn<Accounts, Double> tableColumnBalance;
    @FXML
    private TableColumn<Accounts, String> tableColumnCreationDate;
    @FXML
    private Button btnShowAllAccounts;
    @FXML
    private Button btnCreateNewAccount;
    @FXML
    private Button btnUpdateAccountData;
    @FXML
    private Button btnDeleteAccount;
    @FXML
    private Button btnResetData;

    EntityManagerFactory entityMF = Persistence.createEntityManagerFactory("Programming3LabSecondAssignmentPU");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tableColumnID.setCellValueFactory(new PropertyValueFactory("id"));
        this.tableColumnAccountNumber.setCellValueFactory(new PropertyValueFactory("accountNumber"));
        this.tableColumnUserName.setCellValueFactory(new PropertyValueFactory("username"));
        this.tableColumnCurrency.setCellValueFactory(new PropertyValueFactory("currency"));
        this.tableColumnBalance.setCellValueFactory(new PropertyValueFactory("balance"));
        this.tableColumnCreationDate.setCellValueFactory(new PropertyValueFactory("creationDate"));

    }

    @FXML
    private void showAccountsMethod(ActionEvent event) {
        AccountsJpaController cont = new AccountsJpaController(entityMF);
        List<Accounts> accounts = cont.findAccountsEntities();
        tableViewAccounts.setItems(FXCollections.observableArrayList(accounts));
    }

    @FXML
    private void createAccountMethod(ActionEvent event) throws IOException {
        ViewManager.openAddNewAccountStage();
    }

    @FXML
private void updateAccountsMethod(ActionEvent event) throws IOException {
    // Get the selected account
    Accounts selectedAccount = tableViewAccounts.getSelectionModel().getSelectedItem();

    if (selectedAccount != null) {
        // Open the edit page and pass the selected account data
        ViewManager.openEditAccountDataStage(selectedAccount);
    } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Failed!");
        alert.setContentText("Please Choose an Account to Update!");
        alert.showAndWait();
    }
}

    @FXML
    private void deleteAccountMethod(ActionEvent event) {

            Accounts selectedAccount = tableViewAccounts.getSelectionModel().getSelectedItem();
            if (selectedAccount != null) {
                try {
                    AccountsJpaController cont = new AccountsJpaController(entityMF);
                    cont.destroy(selectedAccount.getId());
                    tableViewAccounts.getItems().remove(selectedAccount);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Successfull!");
                    alert.setContentText("Account Deleted Successfully!");
                    alert.showAndWait();
                } catch (NonexistentEntityException ex) {
                   
                }
            }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Failed!");
            alert.setContentText("Please Choose An Account To Delete!");
            alert.showAndWait();
            }

      
            
        
    }

    @FXML
    private void resetDataMethod(ActionEvent event) {
        this.tableViewAccounts.getItems().clear();
    }

}
