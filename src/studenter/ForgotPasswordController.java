/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.controlsfx.control.Notifications;
import static training.mainClass.*;
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ForgotPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public TextField enrollment;
    public TextField email;
    public TextField otp;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String enroll=enrollment.getText();
       
        
    }

    @FXML
    private void sendOTP(ActionEvent event) throws AddressException, MessagingException {
        final String from = "robinsingh.02@gmail.com"; // change accordingly
          final String password = "9893713155"; // change accordingly
          String to = email.getText(); // change accordingly
          tempemail=to;
          String host = "smtp.gmail.com"; // or IP address

          Properties properties = System.getProperties();

          properties.put("mail.smtp.host", host);
          properties.put("mail.smtp.port", 587);
          properties.put("mail.smtp.auth", "true");
          properties.put("mail.smtp.starttls.enable", "true");
          properties.put("mail.user", from);
          properties.put("mail.password", password);

          Authenticator auth = new Authenticator()
          {
              public PasswordAuthentication getPasswordAuthentication()
              {
                  return new PasswordAuthentication(from, password);
              }
          };
          Session session = Session.getInstance(properties, auth);

          try
          {
             // Create a default MimeMessage object.
             MimeMessage message = new MimeMessage(session);

             message.setFrom(new InternetAddress(from));

             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

             // Set Subject: header field
             message.setSubject("OTP for change password.");
             int randomPin   =(int) (Math.random()*9000)+1000; 
             String otp  = String.valueOf(randomPin);
             message.setText("Your OTP to change password is: "+otp);
             nowotp=otp;
             
             Transport.send(message);
             System.out.println("Sent message successfully....");
             Notifications noti = Notifications.create()
                    .title("OTP")
                    .text("OTP sent successfully!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.show();
          }
          catch (SendFailedException mex)
          {
             mex.printStackTrace();
          }
    }

    @FXML
    private void verifyOTP(ActionEvent event) throws IOException {
        if(nowotp.equals(otp.getText()))
        {
            Notifications noti = Notifications.create()
                    .title("OTP")
                    .text("OTP Verified!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.show();
            Parent pt=FXMLLoader.load(getClass().getResource("ChangePasswordOTP.fxml"));
        Scene ps=new Scene(pt);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ps);
        window.show();
        }
        else
        {
            Notifications noti = Notifications.create()
                    .title("OTP")
                    .text("Wrong OTP Please Retry!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER);
            noti.darkStyle();
            noti.showError();
        }
        
    }
}
