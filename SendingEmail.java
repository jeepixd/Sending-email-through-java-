import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;


public class SendingEmail {
    public static void main(String[] args) {
        final String senderEmail ="jeepitwitter@gmail.com";
        final String senderPassword="sfhlvucfdjoozmic";
        final String reciverEmail="lamichhanenayan099@gmail.com";



        //setting up smtp properties
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");


        //create a session with authentication
        Session session = Session.getInstance(prop, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(senderEmail, senderPassword);

            }
        });
 
        try {
             
             //create message
             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress(senderEmail));
             message.setRecipients(
                Message.RecipientType.TO,
                 InternetAddress.parse(reciverEmail)
                 );
            message.setSubject("Email sent from Jeevsan Shrestha");
            message.setText("Besh ki makichut");

            Transport.send(message);

            System.out.println("email sent successfully");


        }
        catch (MessagingException e){
            e.printStackTrace();
        }
    }
    
    }
