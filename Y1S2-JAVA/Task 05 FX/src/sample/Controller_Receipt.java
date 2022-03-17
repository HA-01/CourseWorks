package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Controller_Receipt {

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblSurname;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblNICorPassport;

    @FXML
    private Label lblVaccine;

    @FXML
    private Label lblBooth;

    @FXML
    private Label lblDateTime;

    public void FN(String FirstName) {
        lblFirstName.setText(FirstName);
        System.out.println(FirstName);
    }

    @FXML
    public void SN(String Surname) {
        lblSurname.setText(Surname);
        System.out.println(Surname);
    }

    @FXML
    public void A(String Age) {
        lblAge.setText(Age);
        System.out.println(Age);
    }

    @FXML
    public void C(String City) {
        lblCity.setText(City);
        System.out.println(City);
    }

    @FXML
    public void ID(String ID) {
        lblNICorPassport.setText(ID);
        System.out.println(ID);
    }

    @FXML
    public void VR(String Vaccination) {
        lblVaccine.setText(Vaccination);
        System.out.println(Vaccination);
    }

    @FXML
    public void B(String BoothNumber) {
        lblBooth.setText(BoothNumber);
        System.out.println(BoothNumber);
    }

    @FXML
    public void initialize(){
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd  hh:mm:ss").format(Calendar.getInstance().getTime());
        lblDateTime.setText(timeStamp );
    }


}