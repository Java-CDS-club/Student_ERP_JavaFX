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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class NewLoginController implements Initializable {

    @FXML
    private AnchorPane anchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void myInfo(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("MyInfo.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }

    private void attendance(ActionEvent event) throws IOException {
         Parent pt = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }


    private void logout(ActionEvent event) {
        System.exit(0);
    }

    private void changepassword(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }


    private void classinfo(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("ClassInfo.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }

    @FXML
    private void updateinfo(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("UpdateStudentInfo.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show(); 
    }

    @FXML
    private void adminresult(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("AdminResult.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show(); 
    }

    
}
