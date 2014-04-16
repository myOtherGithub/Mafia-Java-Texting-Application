/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werewolfgamenontexting;

/**
 *
 * @author CHaDOS
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMessage {
    Session session = Session.getDefaultInstance(properties(),
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("werewolftextgame@gmail.com","legateau18");
				}
			});
    
    
    static Properties properties(){
                Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
                return props;
    }
    
       
    public void sendMessage(String messagebody){
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("werewolftextgame@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("3369095451@vtext.com"));
			//message.setSubject("Testing Subject");
			message.setText(messagebody);
                        // adding the strings creates a new line
			Transport.send(message);
			System.out.println("sentmessage!");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        }
        
         void sendMessage(String sendto, String messagebody){
                try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("werewolftextgame@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(sendto));
			//message.setSubject("Testing Subject");
			message.setText(messagebody);
                        // adding the strings creates a new line
			Transport.send(message);
			System.out.println("sentmessage!");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        }
        
        
         void sendAll(ArrayList <Player> theseplayers, String messagebody){
                String masssend ="";
                for(int i=0; i< theseplayers.size(); i++){
                    if(!theseplayers.get(i).computer){
                        masssend += theseplayers.get(i).email + " , ";
                    }
                }
                
                
                if(masssend.endsWith(",")){
                     masssend = masssend.substring(0, masssend.length()-1);
                }
                
                
                try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("werewolftextgame@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(masssend));
			//message.setSubject("Testing Subject");
			message.setText(messagebody);
                        // adding the strings creates a new line
			Transport.send(message);
			System.out.println("sentmessage!");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
         }
         
         void sendAllLiving(ArrayList <Player> theseplayers, String messagebody){
                String masssend ="";
                for(int i=0; i< theseplayers.size(); i++){
                    if(theseplayers.get(i).living && !theseplayers.get(i).computer){
                         masssend += theseplayers.get(i).email + " , ";
                    }
                }
                
                if (masssend.equals("")){
                    
                }else{
                
                if(masssend.endsWith(",")){
                     masssend = masssend.substring(0, masssend.length()-1);
                }
                
                
                try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("werewolftextgame@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(masssend));
			//message.setSubject("Testing Subject");
			message.setText(messagebody);
                        // adding the strings creates a new line
			Transport.send(message);
			System.out.println("sentmessage!");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
            }
         }    
}
        
        
        
        
        
        
        
        
        


