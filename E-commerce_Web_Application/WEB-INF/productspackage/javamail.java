/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productspackage;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author Arj
 */
public class javamail {
    public static void sendMail(String to, String from, String subject, String body, Boolean bodyIsHTML)
            throws MessagingException {
        //get a mail seesion
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        //create message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML)
            message.setContent(body, "text/html");
        else
            message.setText(body);
        
        // address the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        
        //send the message
        Transport transport = session.getTransport();
        transport.connect("hellboyarj@gmail.com","shawnmicheals");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();  
    }
}
