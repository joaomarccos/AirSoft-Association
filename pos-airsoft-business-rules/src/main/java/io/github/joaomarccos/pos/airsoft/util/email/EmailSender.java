package io.github.joaomarccos.pos.airsoft.util.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class EmailSender {

    public void sendEmail(String to, String msg, String subject) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSslSmtpPort("465");
        email.setStartTLSRequired(true);
        email.setSSLOnConnect(true);
        email.setAuthenticator(new DefaultAuthenticator("usuario", "senha"));
        email.setFrom("joaomarccos.ads@gmail.com");
        email.setDebug(true);
        email.setSubject(subject);
        email.setMsg(msg);
        email.addTo(to);
        email.send();
    }

}
