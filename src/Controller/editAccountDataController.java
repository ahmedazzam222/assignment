package Controller;

import Model.Accounts;
import View.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class editAccountDataController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField textFieldAccountNumber;

    @FXML
    private TextField textFieldBalance;

    @FXML
    private TextField textFieldCreationDate;

    @FXML
    private TextField textFieldCurrency;

    @FXML
    private TextField textFieldUserName;
    private EntityManagerFactory entityMF = Persistence.createEntityManagerFactory("Programming3LabSecondAssignmentPU");

    private Accounts selectedAccount;

    public editAccountDataController() {

    }

    @FXML
    void cancelMethod(ActionEvent event) {
        ViewManager.closeEditAccountDataStage();

    }

    @FXML
    void saveAccountMethod(ActionEvent event) throws Exception {
        if (selectedAccount != null) {
            selectedAccount.setAccountNumber(Integer.parseInt(textFieldAccountNumber.getText()));
            selectedAccount.setUsername(textFieldUserName.getText());
            selectedAccount.setCurrency(textFieldCurrency.getText());
            selectedAccount.setBalance(Double.parseDouble(textFieldBalance.getText()));
            selectedAccount.setCreationDate(textFieldCreationDate.getText());

            AccountsJpaController cont = new AccountsJpaController(entityMF);
            cont.edit(selectedAccount);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Successful");
            alert.setContentText("Data Updtaed Successfully");
            alert.showAndWait();
        }
    }

    public void setAccountData(Accounts selectedAccount) {
        this.selectedAccount = selectedAccount;
        textFieldAccountNumber.setText(String.valueOf(selectedAccount.getAccountNumber()));
        textFieldUserName.setText(selectedAccount.getUsername());
        textFieldCurrency.setText(selectedAccount.getCurrency());
        textFieldBalance.setText(String.valueOf(selectedAccount.getBalance()));
        textFieldCreationDate.setText(selectedAccount.getCreationDate());
    }

}
