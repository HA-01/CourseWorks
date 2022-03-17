package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Details implements Initializable {

    @FXML
    private TextField textFfirstName;

    @FXML
    private TextField txtFSurname;

    @FXML
    private TextField txtFage;

    @FXML
    private TextField txtFCity;

    @FXML
    private TextField txtFNICorPassport;

    @FXML
    private ChoiceBox<String> txtFSelection;
    private String[] Vaccination = {"AstraZeneca", "Sinopharm", "Pfizer"};

    @FXML
    private TextField txtFBooth;

    @FXML
    private Button BtnGenReceipt;

    @FXML
    public void generate() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Receipt.fxml"));
            Parent root = loader.load();

            Controller_Receipt controlling_reciept = loader.getController();
            controlling_reciept.FN(textFfirstName.getText());
            controlling_reciept.SN(txtFSurname.getText());
            controlling_reciept.A(txtFage.getText().toString());
            controlling_reciept.C(txtFCity.getText());
            controlling_reciept.ID(txtFNICorPassport.getText());
            controlling_reciept.VR(txtFSelection.getValue());
            controlling_reciept.B(txtFBooth.getText().toString());

            Stage stage = (Stage) BtnGenReceipt.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Vaccination Center");

            primaryStage.show();

        }catch (IOException ex){
            System.err.println(ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtFSelection.getItems().addAll(Vaccination);
    }
}