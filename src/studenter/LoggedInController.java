/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static training.mainClass.*;
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class LoggedInController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Label display;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        display.setText("Welcome Robin Singh Chouhan"+name);
    }    

    @FXML
    private void myinfo(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("MyInfo.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }

    @FXML
    private void attendance(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }

    @FXML
    private void result(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("Result.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }

    @FXML
    private void logout(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void changepassword(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }

    @FXML
    private void fees(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("Fees.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }
    
}
