/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UpdateResultController implements Initializable {

    ObservableList list=FXCollections.observableArrayList();
    @FXML
    private Label l11;
    @FXML
    private Label l12;
    @FXML
    private Label l13;
    @FXML
    private Label l14;
    @FXML
    private Label l15;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private TextField search;
    @FXML
    private Label name;
    @FXML
    private ChoiceBox<?> selects;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }  
     private void loadData(){
        list.removeAll(list);
        String a="MST-1";
        String b="MST-2";
        String c="Internals";
        String d="Externals";
        String e="End-Sem";
        list.addAll(a,b,c,d,e);
        selects.getItems().addAll(list);
    }

    @FXML
    private void changepassword(ActionEvent event) {
        
    }

    @FXML
    private void fees(ActionEvent event) {
    }

    @FXML
    private void classinfo(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void display(ActionEvent event) {
    }

    @FXML
    private void searched(ActionEvent event) {
        Notifications noti = Notifications.create()
                    .title("SEARCH")
                    .text("RECORD FOUND!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.show();
    }

    @FXML
    private void update(ActionEvent event) {
        
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
         Parent pt = FXMLLoader.load(getClass().getResource("AdminLoggedIn.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }
    
}
