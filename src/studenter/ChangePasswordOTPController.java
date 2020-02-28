/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenter;

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
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import static training.mainClass.*;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ChangePasswordOTPController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public TextField newpasss;
    public TextField confirmnewpass;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loggedpass=tempemail;
        
    }    

    @FXML
    private void confirm(ActionEvent event) throws IOException {
        System.out.println(newpasss.getText()+" "+confirmnewpass.getText());
        if(newpasss.getText().equals(confirmnewpass.getText()))
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
            ps.setString(1,newpasss.getText());
            ps.setString(2,tempemail);
            ps.executeUpdate();
            }
            catch(SQLException e)
            {
                
            }
             Parent pt = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
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
}
