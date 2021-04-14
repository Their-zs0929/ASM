/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import java.io.Serializable;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message; 
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Lucires
 */
public class SendMail implements Serializable{
    public void sendText(String email, String total) throws AddressException, MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;

        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);

        // thay abc@gmail.com bằng địa chỉ người nhận
        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        // Bạn có thể chọn CC, BCC
        // generateMailMessage.addRecipient(Message.RecipientType.CC, new
        // InternetAddress("cc@gmail.com")); //Địa chỉ cc gmail
        mailMessage.setSubject("Xac nhan don hang");
        mailMessage.setText("Xac nhan don hang ban da dat tong cong la : " + total);

        // Step3: Send mail
        Transport transport = getMailSession.getTransport("smtp");

        // Thay your_gmail thành gmail của bạn, thay your_password thành mật khẩu gmail của bạn
        transport.connect("smtp.gmail.com", "phungnlkse140730@fpt.edu.vn", "Lucir3sriehT");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
    }

}
