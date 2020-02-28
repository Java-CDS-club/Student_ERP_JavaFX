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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ResultController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ObservableList list=FXCollections.observableArrayList();
    public String marks="",choice="";
    @FXML
    private ChoiceBox<String> Select;
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
    public int i=0;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        
    }    
    private void loadData(){
        list.removeAll(list);
        Select.setValue("-- Select --");
        String a="MST-1";
        String b="MST-2";
        String c="Internals";
        String d="Externals";
        String e="End-Sem";
        list.addAll(a,b,c,d,e);
        Select.getItems().addAll(list);
    }

    @FXML
    private void display(ActionEvent event) {
        i++;
        
        if(i==1)
        {
            l1.setText(""+18);
            l2.setText(""+19);
            l3.setText(""+20);
            l4.setText(""+19);
            l5.setText(""+18);
        }
        else if(i==2)
        {
            l1.setText(""+17);
            l2.setText(""+20);
            l3.setText(""+19);
            l4.setText(""+17);
            l5.setText(""+18);
        }
        else if(i==3)
        {
            l1.setText(""+18);
            l2.setText(""+20);
            l3.setText(""+19);
            l4.setText(""+17);
            l5.setText(""+18);
        }
        else if(i==4)
        {
            l1.setText(""+20);
            l2.setText(""+20);
            l3.setText(""+19);
            l4.setText(""+17);
            l5.setText(""+18);
        }
        else if(i==5)
        {
            l1.setText(""+52);
            l2.setText(""+50);
            l3.setText(""+55);
            l4.setText(""+48);
            l5.setText(""+49);
            l11.setText(""+60);
            l12.setText(""+60);
            l13.setText(""+60);
            l14.setText(""+60);
            l15.setText(""+60);
            i=0;
        }
        
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }

    private void myinfo(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("MyInfo.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
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
    private void classinfo(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("ClassInfo.fxml"));
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
    private void fees(ActionEvent event) {
        
    }

}
