/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.session;

import ec.edu.espe.arquitectura.model.Transaccion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class MailSession {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String FROM = "pruebaarqui4@gmail.com";
    private String FROMNAME = "userPrueba";
    private String PASS = "Pruebaarqui123";

    // Replace recipient@example.com with a "To" address. If your account 
    // is still in the sandbox, this address must be verified.
    private String TO = "pruebaarqui4@gmail.com";

    // Replace smtp_username with your Amazon SES SMTP user name.
    private String SMTP_USERNAME = "smtp_username";

    // Replace smtp_password with your Amazon SES SMTP password.
    private String SMTP_PASSWORD = "smtp_password";

    // The name of the Configuration Set to use for this message.
    // If you comment out or remove this variable, you will also need to
    // comment out or remove the header below.
    private String CONFIGSET = "ConfigSet";

    // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
    // See https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
    // for more information.
    private String HOST = "smtp.gmail.com";

    // The port you will connect to on the Amazon SES SMTP endpoint. 
    private int PORT = 587;

    private String SUBJECT = "Notificación sistema en línea - Banco BanQuito";

    private String BODY;

    Transaccion trans;

    public void enviarMail(Transaccion mail, String Nombres, String Correo) throws Exception {
        // Create a Properties object to contain connection configuration information.
        trans = mail;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        TO = Correo;

        // Create a Session object to represent a mail session with the specified properties. 
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PASS);
            }
        });

        BODY = this.msgBody(trans.getTipo(),Nombres);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM, FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY, "text/html");

        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
        msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);

        // Create a transport.
        //Transport transport = session.getTransport();
        // Send the message.
        try {

            System.out.println("Sending...");

            // Connect to Amazon SES using the SMTP username and password you specified above.
            //transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            // Send the email.
            //transport.sendMessage(msg, msg.getAllRecipients());
            Transport.send(msg);
            System.out.println("Email sent!");
        } catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        } finally {
            // Close and terminate the connection.
            //transport.close();
        }
    }

    public String msgBody(String tipo, String Nombres) {
        String msg = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String plant="";
        msg = String.join(
                System.getProperty("line.separator"),
                "<div style=\"display: block;\n"
                + "  margin-left: auto;\n"
                + "  margin-right: auto;\n"
                + "  width: 50%;\" >\n"
                + "    <a  href=\"https://ibb.co/Y0gQR2C\"><img src=\"https://i.ibb.co/Bnk3zLp/banner.png\" alt=\"banner\" border=\"0\"></a>    \n"
                + "</div>"
                + "<div>"
                + "        <b>Estimado/a.</b>\n"
                + "        <br/>"+Nombres+".\n"
                + "        <br/>\n"
                + "        \n"
                + "        <br/>Usted ingresó a su Banca Electrónica.\n"
                + "        <br/> id del usuario: " + trans.getUserId()
                + "        <br/> numero de cuenta: " + trans.getNumCuenta()
                + "        <br/> tipo de transacción: " + trans.getTipo()
                + "        <br/> fecha de la trans: " + dtf.format(now)
                + "        <br/> monto de la transacción: " + trans.getMonto()
                + "        \n"
                + "        <br/><br/>En caso de no haber realizado esta operación comuníquese inmediatamente al 02-2999-999 o para más informacion ingrese al sitio web en el siguiente link \n"
                + "        <a href='https://www.google.com'>Banco BanQuito</a>\n"
                + "        \n"
                + "        <br/>\n"
                + "        <br/><b>Asesor Virtual</b>\n"
                + "        <br/>Banco BanQuito\n"
                + "\n"
                + "    </p>\n"
                + "\n"
                + "</div>"
        );

        return msg;
    }
    
    
}
