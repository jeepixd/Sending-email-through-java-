
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;


public class SendingEmail {
    public static void main(String[] args) {
        final String senderEmail ="jeepitwitter@gmail.com";//ur email
        final String senderPassword="";//ur app password
        final String reciverEmail="hussguss64@gmail.com";//reciver email



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
            message.setSubject("Email sent from Jeevsan Shrestha");//email subject
            message.setText("hello world");//email body

            Transport.send(message);

            System.out.println("email sent successfully");


        }
        catch (MessagingException e){
            e.printStackTrace();
        }
    }
    
    }

/*
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class SendingEmail extends Frame {

    private TextField receiverField;
    private TextField subjectField;
    private TextArea bodyArea;
    private Button sendButton;

    // Replace with your email and app password
    private final String senderEmail = "jeepitwitter@gmail.com";
    private final String senderPassword = "";

    public SendingEmail() {
        setTitle("📧 Email Sender");
        setSize(350, 250); // smaller window
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // FlowLayout instead of BorderLayout
        setBackground(new Color(245, 245, 245));

        // Header
        Label header = new Label("Send Email");
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setForeground(Color.BLUE);
        add(header);

        // Receiver Email
        add(new Label("Receiver Email:"));
        receiverField = new TextField(25);
        receiverField.setFont(new Font("Arial", Font.PLAIN, 13));
        add(receiverField);

        // Subject
        add(new Label("Subject:"));
        subjectField = new TextField(25);
        subjectField.setFont(new Font("Arial", Font.PLAIN, 13));
        add(subjectField);

        // Body
        add(new Label("Body:"));
        bodyArea = new TextArea(3, 25); // smaller height
        bodyArea.setFont(new Font("Arial", Font.PLAIN, 13));
        bodyArea.setBackground(new Color(255, 255, 240));
        add(bodyArea);

        // Send Button
        sendButton = new Button("Send");
        sendButton.setBackground(new Color(30, 144, 255));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Arial", Font.BOLD, 12));
        add(sendButton);

        // Action Listener
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendEmail(receiverField.getText(), subjectField.getText(), bodyArea.getText());
            }
        });

        // Window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void sendEmail(String receiverEmail, String subject, String body) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("✅ Email sent successfully!");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SendingEmail();
    }
}
*/