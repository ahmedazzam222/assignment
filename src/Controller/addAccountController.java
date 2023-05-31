/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Accounts;
import View.ViewManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author msi1
 */
public class addAccountController implements Initializable {

    @FXML
    private Button btnCancel;
    @FXML
    private TextField textFieldAccountNumber;
    @FXML
    private TextField textFieldUserName;
    @FXML
    private TextField textFieldCurrency;
    @FXML
    private TextField textFieldBalance;
    @FXML
    private TextField textFieldCreationDate;

    EntityManagerFactory entityMF = Persistence.createEntityManagerFactory("Programming3LabSecondAssignmentPU");
    @FXML
    private Button btnSave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addAccountMethod(ActionEvent event) {

        try {

            Accounts acc = new Accounts(Integer.parseInt(textFieldAccountNumber.getText()), textFieldUserName.getText(),
                    textFieldCurrency.getText(), Double.parseDouble(this.textFieldBalance.getText()), this.textFieldCreationDate.getText());
            AccountsJpaController cont = new AccountsJpaController(entityMF);
            cont.create(acc);
            this.clearFields();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Successfull!");
            alert.setContentText("Account Added Successfully!");
            alert.showAndWait();

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Failed!");
            alert.setContentText("Failed To Add Account the username you entered doesn't Exist!");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelMethod(ActionEvent event) {
        ViewManager.closeAddNewAccountStage();
    }

    public void clearFields() {
        this.textFieldAccountNumber.clear();
        this.textFieldBalance.clear();
        this.textFieldCreationDate.clear();
        this.textFieldCurrency.clear();
        this.textFieldUserName.clear();

    }

    @FXML
    private void saveAccountMethod(ActionEvent event) {
    }

}
