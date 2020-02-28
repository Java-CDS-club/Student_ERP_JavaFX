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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static training.mainClass.*;

public class MyInfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public TextField t1;
    public TextField t2;
    public TextField t3;
    public TextField t4;
    public TextField t5;
    public TextField t6;
    public TextField t7;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        t1.setText(loggedenroll);
        t2.setText(name);
        t4.setText(loggedgender);
        t6.setText(loggedname);
        t7.setText(loggedmobile);
        t3.setText(loggedbirth);
        t5.setText(loggedsem);
    }    

    @FXML
    private void home(MouseEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
    }

    private void changePassword(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show(); 
    }

    @FXML
    private void logout(ActionEvent event) {
        System.exit(0);
    }

    private void classInfo(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("ClassInfo.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show(); 
    }
}
