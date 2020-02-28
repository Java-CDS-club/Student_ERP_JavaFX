/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenter;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import static training.mainClass.*;


public class SignInController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        String user=email.getText();
        String pass=password.getText();
        int status=0;
        String database_uname="root";
        String database_pass="1234";
        String con="jdbc:mysql://localhost:3306/test";
        try {
            Connection conn=(Connection) DriverManager.getConnection(con, database_uname, database_pass);
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from student;");
            while(rs.next())
            {
                if(user.equals(rs.getString(2)) && pass.equals(rs.getString(3)))
                {
                    loggedname=user;
                    loggedpass=pass;
                    name=rs.getString(1);
                    loggedenroll=rs.getString(4);
                    loggedmobile=rs.getString(6);
                    loggedgender=rs.getString(5);
                    loggedbirth=rs.getString(7);
                    loggedsem=rs.getString(8);
            status=0;
            Notifications noti = Notifications.create()
                    .title("LOGIN")
                    .text("SUCCESSFULLY LOGGED IN!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.show();
            Parent pt = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
                }
                else  if(user.equals("admin") && pass.equals("admin"))
            {
            Parent pt = FXMLLoader.load(getClass().getResource("AdminLoggedIn.fxml"));
            Scene ps = new Scene(pt);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ps);
            window.show();
            }
            else
            {
                status=1;
            }
                
            }
            if(status==1)
            {
                Notifications noti = Notifications.create()
                    .title("ERROR")
                    .text("INVALID CREDENTIALS!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.showError();
            }
        } catch (SQLException ex) {           
        }
    }
    @FXML
    private void forgot(ActionEvent event) throws IOException {
        Parent pt=FXMLLoader.load(getClass().getResource("forgotPassword.fxml"));
        Scene ps=new Scene(pt);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ps);
        window.show();
    }
}
