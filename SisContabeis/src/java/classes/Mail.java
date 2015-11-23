/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.net.MalformedURLException;  
import java.net.URL;  
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
  
import org.apache.commons.mail.EmailException;  
public class Mail {  
      
    public Mail() throws EmailException, MalformedURLException {  
        //enviaEmailSimples();  
        //enviaEmailComAnexo();  
        //enviaEmailFormatoHtml();  
    }  
      
    /** 
     * envia email simples(somente texto) 
     * @throws EmailException 
     */  
    public void enviarEmail(String cpf, String nome, String op1, String op2, String op3, String email) throws EmailException, MessagingException {
        String username = "siscontabeis@gmail.com";
        String password = "contabilidade001"; 
        String recipient = "siscontabeis@gmail.com";
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.from", email);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.setProperty("mail.debug", "true");

        Session session = Session.getInstance(props, null);
        MimeMessage msg = new MimeMessage(session);

        msg.setRecipients(Message.RecipientType.TO, recipient);
        msg.setSubject("Solicitação - Consulta Pŕevia"); 
        msg.setSentDate(new Date());
        msg.setText("Você recebeu uma nova solicitação para consulta prévia.\n\n" + 
        "CPF/CNPJ: " + cpf + "\n" +  
        "Nome: " + nome + "\n" +
        "Data: " + getData() + "\n" + 
        "Nome 1: " + op1 + "\n" + 
        "Nome 2: " + op2 + "\n" +
        "Nome 3: " + op3 + "\n"); 
        Transport transport = session.getTransport("smtp");

        transport.connect(username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    }
    
    public void enviarEmailResposta(String cpf, String nome, String op1, String op2, String op3, String email, String status, String mensagem) throws EmailException, MessagingException {
        String username = "siscontabeis@gmail.com";
        String password = "contabilidade001"; 
        String recipient = email;
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.from", "siscontabeis@gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.setProperty("mail.debug", "true");

        Session session = Session.getInstance(props, null);
        MimeMessage msg = new MimeMessage(session);

        msg.setRecipients(Message.RecipientType.TO, recipient);
        msg.setSubject("Solicitação - Consulta Pŕevia"); 
        msg.setSentDate(new Date());
        msg.setText("Resposta Consulta Prévia.\n\n" + 
        "CPF/CNPJ: " + cpf + "\n" +  
        "Nome: " + nome + "\n" +
        "Data: " + getData() + "\n" + 
        "Nome 1: " + op1 + "\n" + 
        "Nome 2: " + op2 + "\n" +
        "Nome 3: " + op3 + "\n" +
        "A sua solicitação de consulta prévida foi: " + status + "\n" + 
        "Observações sobre a sua solicitação: " + mensagem);
  
        Transport transport = session.getTransport("smtp"); 

        transport.connect(username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    }
    
    public String getData() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        Date date = new Date(); 
        return dateFormat.format(date);
    }
    
}  
