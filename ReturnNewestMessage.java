/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werewolfgamenontexting;

/**
 *
 * @author CHaDOS
 */

/**
 *
 * @author CHaDOS
 */
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;


public class ReturnNewestMessage {
    public static void main() {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "werewolftextgame@gmail.com", "legateau18");
            
            
          //  Folder inbox = store.getFolder("INBOX");
          //  inbox.open(Folder.READ_ONLY); //opens inbox
            
            
          //  Message msg = inbox.getMessage(inbox.getMessageCount());
            
          //  Address[] in = msg.getFrom();
            
          //  for (Address address : in) {
          //      System.out.println("FROM:" + address.toString());
          //  }
            
          //  Multipart mp = (Multipart) msg.getContent();
          //  BodyPart bp = mp.getBodyPart(0);
          //  System.out.println("SENT DATE:" + msg.getSentDate());
          //  System.out.println("SUBJECT:" + msg.getSubject());
          //  System.out.println("CONTENT:" + bp.getContent());
            
            
            
            
        } catch (Exception mex) {
            mex.printStackTrace();
        }
}   
    
    
    
    
  
  public ArrayList<MessageTracker>  returnmessage2(ArrayList<Player> myarray){
       int sleeptime = 10000;
       boolean mytest = true;
       Date firstDate = null;
       String content = null;
       ArrayList<MessageTracker> returnmessages = new ArrayList();
       ArrayList<Message> msg = new ArrayList();
       SendMessage sendmessage = new SendMessage();
       String sender;
        
//get the date of the first called message
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "werewolftextgame@gmail.com", "legateau18");
            
            
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE); //opens inbox
            
            int totalcount = inbox.getMessageCount();
             System.out.println(totalcount); //54
            int newcount = inbox.getUnreadMessageCount();
             System.out.println(newcount); //4
            int totalnewcount = totalcount-newcount;
            
            System.out.println(totalnewcount); //50
            
            if(newcount > 0){
                for(int m=0; m<newcount; m++){
                    msg.add(inbox.getMessage(totalcount-m));
                }
                for(int n=0; n<msg.size(); n++){
                    Address[] in = msg.get(n).getFrom();
                    for (Address address : in) {
                        System.out.println("FROM:" + address.toString());
                        }
                    Multipart mp = (Multipart) msg.get(n).getContent();
                    BodyPart bp = mp.getBodyPart(0);
                    firstDate = msg.get(n).getSentDate();
                    
                    
                    
                    if(bp.getContent().toString().contains("/msg")){
                        for(int p=0; p<=myarray.size(); p++){
                            if(myarray.get(p).email.equals(in[0].toString())){
                                for(int q=0; q<=myarray.size(); q++){
                                    if(bp.getContent().toString().contains(myarray.get(q).name)){
                                        String thisstring = bp.getContentType().toString();
                                        thisstring  = thisstring.substring(4);
                                        sendmessage.sendMessage(myarray.get(q).email, "Msg from" + myarray.get(q).name + ": " + thisstring);
                                    }
                                }
                            }
                        }
                    }
                    else{
                        sender = null;
                     for(int r=0; r<myarray.size(); r++){
                        
                         if(myarray.get(r).email != null && myarray.get(r).email.equals(in[0].toString())){
                             sender = myarray.get(r).name;
                         }
                     }
                          content = bp.getContent().toString();
                          
                       if(content.startsWith("/vote") || content.startsWith("/bite") || content.startsWith("/seer")){
                           if(sender != null){
                                returnmessages.add(new MessageTracker(sender, content));
                           }
                       }
                        
                             
                    }
                }
            }else{
                try {
                    Thread.sleep(sleeptime);
                } catch (InterruptedException ex) {
                }
                
                returnmessages = returnmessage2(myarray);
                //wait
            }
            } catch (Exception mex) {
                    mex.printStackTrace();
            }
            return returnmessages;
        }
  
  
  
  
  
  
  
  
  
  
  
  
  
  public String  returnmessage3(ArrayList<Player> myarray){
       int sleeptime = 5000;
       boolean mytest = true;
       Date firstDate = null;
       String content = null;
       ArrayList<Message> msg = new ArrayList();
       SendMessage sendmessage = new SendMessage();
        
//get the date of the first called message
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "werewolftextgame@gmail.com", "legateau18");
            
            
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE); //opens inbox
            
            int totalcount = inbox.getMessageCount();
            int newcount = inbox.getUnreadMessageCount();
            int totalnewcount = totalcount-newcount;
            
            if(totalnewcount > 0){
                for(int m=0; m<totalnewcount; m++){
                    msg.add(inbox.getMessage(totalcount-m));
                }
                for(int n=0; n<msg.size(); n++){
                    Address[] in = msg.get(n).getFrom();
                    for (Address address : in) {
                        System.out.println("FROM:" + address.toString());
                        }
                    Multipart mp = (Multipart) msg.get(n).getContent();
                    BodyPart bp = mp.getBodyPart(0);
                    firstDate = msg.get(n).getSentDate();
                    
                    
                    
                    if(bp.getContent().toString().contains("/msg")){
                        for(int p=0; p<=myarray.size(); p++){
                            if(myarray.get(p).email.equals(in[0].toString())){
                                for(int q=0; q<=myarray.size(); q++){
                                    if(bp.getContent().toString().contains(myarray.get(q).name)){
                                        sendmessage.sendMessage(myarray.get(q).email, bp.getContent().toString());
                                    }
                                }
                            }
                        }
                    }
                    else{
                     content = bp.getContent().toString();   
                    }
                }
            }else{
                try {
                    Thread.sleep(sleeptime);
                } catch (InterruptedException ex) {
                }
                
                content = returnmessage3(myarray);
                //wait
            }
            } catch (Exception mex) {
                    mex.printStackTrace();
            }
            return content;
        }
         
         
  
  
  
  
  
  
  
  
  
        //    Message msg = inbox.getMessage(inbox.getMessageCount()); //this gets the very last message
            //inbox.getUnreadMessageCount();
            //System.out.println(inbox.getUnreadMessageCount()); //tells us how many we need to get
            
            
          //  Address[] in = msg.getFrom();
            
           // for (Address address : in) {
             //   System.out.println("FROM:" + address.toString());
            //}
            
            //Multipart mp = (Multipart) msg.getContent();
            //BodyPart bp = mp.getBodyPart(0);
            //firstDate = msg.getSentDate();
       // } catch (Exception mex) {
         //   mex.printStackTrace();
        //}
        
        //return content;   
        //}
        
         
//initialize first sleep 
 //       while(mytest==true){
            
   //     System.out.println("checking...");
     //   try {
   //         Thread.sleep(sleeptime);
   //     } catch (InterruptedException ex) {
            
   //     }
        
        
        //do this after sleep
        
     //   props = new Properties();
     //   props.setProperty("mail.store.protocol", "imaps");
     //   try {
     //       Session session = Session.getInstance(props, null);
     //       Store store = session.getStore();
     //       store.connect("imap.gmail.com", "werewolftextgame@gmail.com", "legateau18");
            
            
     //       Folder inbox = store.getFolder("INBOX");
     //       inbox.open(Folder.READ_ONLY); //opens inbox
            
            
     //       Message msg2 = inbox.getMessage(inbox.getMessageCount());
            
     //       Address[] in = msg2.getFrom();
            
     //       for (Address address : in) {
                //System.out.println("FROM:" + address.toString());
     //       }
            
     //       Multipart mp = (Multipart) msg2.getContent();
     //       BodyPart bp = mp.getBodyPart(0);
           
            
     //       if(msg2.getSentDate().after(firstDate)){
     //           content = bp.getContent().toString();
     //           System.out.println("NEW MESSAGE: "+ content);
     //           return content;
     //       }
     //       else{
     //           System.out.println("no new messages yet");
     //       }
            
            
            
            
     //  } catch (Exception mex) {
     //       mex.printStackTrace();
     //   }
        
                
     //   sleeptime*=2;
     //   }
        
        
     //   return content;
        
     // }
  
  
  
  
  
  
  
  
  
  
  
  
  public String returnatt(){
      
       int sleeptime = 5000;
       boolean mytest = true;
       Date firstDate = null;
       String content = null;
        
        
//get the date of the first called message
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "werewolftextgame@gmail.com", "legateau18");
            
            
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY); //opens inbox
            
            
            Message msg = inbox.getMessage(inbox.getMessageCount());
            
            Address[] in = msg.getFrom();
            
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            
            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);
            //firstDate = msg.getSentDate();
            
            
        
         
            
               
         
//initialize first sleep 
        while(mytest==true){
            
        System.out.println("checking...");
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException ex) {
            
        }
        
        
        //do this after sleep
        
        //props = new Properties();
        //props.setProperty("mail.store.protocol", "imaps");
        try {
          //  Session session = Session.getInstance(props, null);
         //   Store store = session.getStore();
        //    store.connect("imap.gmail.com", "werewolftextgame@gmail.com", "legateau18");
            
            
            inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY); //opens inbox
            
            
            msg = inbox.getMessage(inbox.getMessageCount());
            
            in = msg.getFrom();
            
            for (Address address : in) {
                //System.out.println("FROM:" + address.toString());
            }
            
             mp = (Multipart) msg.getContent();
             bp = mp.getBodyPart(0);
            
            if(msg.getSentDate().after(firstDate)){
                content = bp.getContent().toString();
                System.out.println("NEW MESSAGE: "+ content);
                
                
                
                if(content.contains("/msg")){
                    
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                return content;
            }
            else{
                System.out.println("no new messages yet");
            }
            
            
            
            
        } catch (Exception mex) {
            mex.printStackTrace();
        }
        
        
        
        
                
        sleeptime*=2;
        }
            
            
        } catch (Exception mex) {
            mex.printStackTrace();
        }  
        
        
        return content;
    } 
  }

   
      
      


