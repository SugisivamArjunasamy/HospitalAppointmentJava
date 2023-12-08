package com.example.hospitalappointment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController extends HelloApplication {
    @FXML
    private TextField username;
    @FXML
    private PasswordField myfield;
    @FXML
    private PasswordField pasfield;
    @FXML
    private TextField spc;
    @FXML
    private TextField des;
    @FXML
    private TextField mob;
    @FXML
    private TextField uname;
    @FXML
    private PasswordField upass;
    @FXML
    private  TextField pname;
    @FXML
    private  PasswordField ppass;
    @FXML
    private PasswordField ppass2;
    @FXML
    private TextField mob1;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField name2;
    @FXML
    private TextField date;
    @FXML
    private TextField time;
    @FXML
    private TextField doc;
    @FXML
    private  TextField pat;
    @FXML
    private TextField dat;
    @FXML
    private TextField ti;



    @FXML
    protected void ondocbut() {
        String name = username.getText();
        String passText = myfield.getText();
        String spcText = spc.getText();
        String desText = des.getText();
        String mobText = mob.getText();
        Dbmscon.insertDoctor(name, passText,desText,spcText,mobText);
    }
    @FXML
    protected void onsigButtonClick() {
        String name1 = pname.getText();
        String pass1Text = ppass.getText();
        String mob1Text = mob1.getText();
        Dbmscon.insertPatient(name1, pass1Text,mob1Text);
    }
    @FXML
    protected void onappadButtonClick() {
        String unameText = doc.getText();
        String name2Text = pat.getText();
        String dateText = dat.getText();
        String timeText = ti.getText();
        Dbmscon.insertappointment(unameText, name2Text,dateText,timeText);
    }
    @FXML
    private void onloginButtonClick(ActionEvent event) {
        String username = uname.getText();
        String password = upass.getText();

        // Perform your login check here
        if (isValidLogin(username, password)) {
            statusLabel.setText("Login successful!");
            // You can navigate to another scene or perform other actions upon successful login
        } else {
            statusLabel.setText("Invalid username or password");
        }
    }

    private boolean isValidLogin(String username, String password) {
        // Implement your login validation logic here
        // For example, you can compare against a predefined username and password
        return "yourUsername".equals(username) && "yourPassword".equals(password);
    }




}