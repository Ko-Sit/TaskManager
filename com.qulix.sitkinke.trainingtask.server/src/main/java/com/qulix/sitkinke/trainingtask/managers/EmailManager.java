package com.qulix.sitkinke.trainingtask.managers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.qulix.sitkinke.trainingtask.command.ActionCommand;

/**
 * Class that sends messages to email.
 *
 * @author sitkin
 * @see ActionCommand
 */
public class EmailManager {

    /**
     * sends message.
     *
     * @param email the user email
     * @param password the user password
     */
    public static void send(String email, String password) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("upsitkink", "kostya2121");
                }
            });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("upsitkink@yandex.ru"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("Login password");
        message.setText(password);

        Transport.send(message);
    }

}
