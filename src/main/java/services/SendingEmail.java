package services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendingEmail {
    String HOST_NAME = "smtp.gmail.com";
    String PORT = "465";
    String APP_EMAIL = "cyberbullying.recovery@gmail.com";
    String APP_PASSWORD = "fogrydyztzulwlar";
    
    public int sendEmail(String email){
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", HOST_NAME);
        props.put("mail.smtp.port",PORT);
        props.put("mail.smtp.ssl.enable", "true");
        // get Session
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
            }
        });
        
        session.setDebug(true);
        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(APP_EMAIL)); 
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Verification Code");
            int randomNum = (int)(Math.random() * ((999999 - 100000) + 1)) + 100000;
            message.setText("Your verification code is " + randomNum);
            // send message
            Transport.send(message);
            return randomNum;
        } catch (Exception e) {
            return 0;
        } 
    }
}
