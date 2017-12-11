package util;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtilGmail {
    public static void sendMail(String to,String from,String Subject,String body,boolean bodyIsHTML) throws MessagingException{
        
        
        //1- get a mail session
        Properties props = new Properties();
        props.put("mail.transport.protocol","smtps");
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.port",465);
        props.put("mail.smtps.auth","true");
        props.put("mail.smtps.quitwait","false");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        
        //Create a message
        Message message = new MimeMessage(session);
        message.setSubject(Subject);
        if(bodyIsHTML){
            message.setContent(body,"text/html");
        }
        else{
            message.setText(body);
        }
        
        
        //ADDRESS THE MEssage
        
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO,toAddress);
        
        Transport transport =session.getTransport();
        transport.connect("luuvancan.it@gmail.com", "saobang4311");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
         
    }
}
