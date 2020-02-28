package studenter;

import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import static training.mainClass.*;

public class ChangePasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
     public TextField oldpass;
     public TextField newpass;
     
     String passnew;
    public TextField newpassed;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        passnew=newpass.getText();
        
    }    


    @FXML
    private void ChangePasswords(ActionEvent event) {
        if(oldpass.getText().equals(loggedpass))
        {
            Notifications noti=Notifications.create()
                    .title("Change Password")
                    .text("Password has been chaanged successfully!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.showConfirm();
            String database_uname="root";
            String database_pass="1234";
            String con="jdbc:mysql://localhost:3306/test";
            try{
            Connection conn=(Connection) DriverManager.getConnection(con, database_uname, database_pass);
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement("update student set password=? where email=?");
            ps.setString(1,newpass.getText());
            ps.setString(2,loggedname);
            ps.executeUpdate();
            }
            catch(SQLException e)
            {
                
            }
        }
        else
        {
            Notifications noti=Notifications.create()
                    .title("Change Password")
                    .text("Something went bad!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.showConfirm();
        }
    }
    

    @FXML
    private void personalinfo(ActionEvent event) throws IOException {
         Parent pt = FXMLLoader.load(getClass().getResource("MyInfo.fxml"));
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
    private void home(ActionEvent event) throws IOException {
        Parent pt = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
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