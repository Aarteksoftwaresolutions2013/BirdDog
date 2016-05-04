package com.birddog.util;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 * 
 * @author Aartek
 *
 */
public class SendMailProperty {

    public static Session mailProperty() {

        final String username = IConstant.FROM_EMAIL_ID;
        final String password = IConstant.FROM_PASSWORD;
        Properties props = new Properties();
        props.put(IConstant.PROP_SMTP_HOST, IConstant.SMTP_HOST);
        props.put(IConstant.PROP_SMTP_AUTH, IConstant.SMTP_AUTH);
        props.put(IConstant.PROP_SMTP_PORT, IConstant.SMTP_PORT);
        props.put(IConstant.PROP_SMTP_SOCKET_FACTORY, IConstant.SMTP_SOCKET_FACTORY);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(username, password);
            }

        });

        return session;
    }

}
