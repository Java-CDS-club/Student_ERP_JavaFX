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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import static training.mainClass.loggedbirth;
import static training.mainClass.loggedenroll;
import static training.mainClass.loggedgender;
import static training.mainClass.loggedmobile;
import static training.mainClass.loggedname;
import static training.mainClass.loggedpass;
import static training.mainClass.name;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UpdateStudentInfoController implements Initializable {

    @FXML
    private TextField t1;
    @FXML
    private TextField t5;
    @FXML
    private TextField t4;
    @FXML
    private TextField t3;
    @FXML
    private TextField t2;
    @FXML
    private TextField t7;
    @FXML
    private TextField t6;
    @FXML
    private TextField search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(ActionEvent event) {
        System.exit(0);
    }
    public String updated="";
    @FXML
    private void search(ActionEvent event) {
        String enroll=search.getText();
        String database_uname="root";
        String database_pass="1234";
        String con="jdbc:mysql://localhost:3306/test";
         try {
            Connection conn=(Connection) DriverManager.getConnection(con, database_uname, database_pass);
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from student;");
            while(rs.next())
            {
                if(enroll.equals(rs.getString(4)))
                {
            Notifications noti = Notifications.create()
                    .title("SEARCH")
                    .text("RECORD FOUND!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.show();
            t1.setText(rs.getString(4));
            t2.setText(rs.getString(1));
            t4.setText(rs.getString(5));
            t6.setText(rs.getString(2));
            t7.setText(rs.getString(6));
            t3.setText(rs.getString(7));
            t5.setText(rs.getString(8));
            updated=rs.getString(3);
            conn.close();
            }
                else{
                    Notifications noti = Notifications.create()
                    .title("SEARCH")
                    .text("RECORD NOT FOUND!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.showError();
                }
            }
        } catch (SQLException ex) {           
        }
    }

    @FXML
    private void update(ActionEvent event) {
        Notifications noti = Notifications.create()
                    .title("UPDATE")
                    .text("Record Updated!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.show();
            String database_uname="root";
        String database_pass="1234";
        String con="jdbc:mysql://localhost:3306/test";
        try{
            Connection conn=(Connection) DriverManager.getConnection(con, database_uname, database_pass);
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement("update student set name=?, email=? ,enrollment=? ,mobile=? ,birthday=? ,semester=? where password=?");
            ps.setString(1,t2.getText());
            ps.setString(2,t6.getText());
            ps.setString(3,t1.getText());
            ps.setString(4,t7.getText());
            ps.setString(5,t3.getText());
            ps.setString(6,t5.getText());
            ps.setString(7,updated);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Errror");
        }
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

