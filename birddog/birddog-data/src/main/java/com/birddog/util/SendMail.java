package com.birddog.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Aartek
 *
 */
public class SendMail {

    public static void mailSend(String email, String name, String password) {

        try {

            Message message = new MimeMessage(SendMailProperty.mailProperty());
            message.setFrom(new InternetAddress(IConstant.FROM_EMAIL_ID));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Regards:registration confirmation");
            String msg = "Dear " + name + ",<br>";
            msg += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;You have been registered with birddog and you can access birddog account:<br>";
            msg += " <br>";
            msg += "<b>User EmailId:&nbsp;&nbsp;&nbsp;</b>" + email;
            msg += " <br>";
            msg += "Password=&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + password + "";
            msg += " <br>";
            msg += "Regards,<br>";
            msg += "Birddog";
            message.setContent(msg, "text/html");
            Transport.send(message);
        } catch (MessagingException e) {

            throw new RuntimeException(e);
        }

    }

    public static boolean commomMailSend(String toMailId, String subject, String msg) {
        try {

            Message message = new MimeMessage(SendMailProperty.mailProperty());
            message.setFrom(new InternetAddress(IConstant.FROM_EMAIL_ID));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMailId));
            message.setSubject(subject);
            message.setContent(msg, IConstant.TEXT_HTML);
            Transport.send(message);

        } catch (MessagingException e) {

            e.printStackTrace();

            return false;
        }

        return true;
    }

    public static String forgotPassword(String toEmail, String userPassword, String User) {

        try {

            Message message = new MimeMessage(SendMailProperty.mailProperty());
            message.setFrom(new InternetAddress(IConstant.FROM_EMAIL_ID));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Regards:Forgot password");
            String msg = "Dear " + User + ",<br>";
            msg += "&nbsp;&nbsp;&nbsp;We have received a request to email your password .Please find your log-in credentials below:<br>";
            msg += " <br>";
            msg += "Email ID /Username : " + toEmail + "<br>";
            msg += "Password : " + userPassword + "<br>";
            msg += " <br>";
            msg += "If you have not raised this request , please contact us email at hrd@aartek.co.in<br>";
            msg += " <br>";
            msg += "Regards,<br>";
            msg += "Birddog";
            message.setContent(msg, "text/html");
            Transport.send(message);

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }

        return null;
    }

}
