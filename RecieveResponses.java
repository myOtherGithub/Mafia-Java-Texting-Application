/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werewolfgamenontexting;

import java.util.ArrayList;

/**
 *
 * @author CHaDOS
 */
class RecieveResponses {

    public RecieveResponses() {
        
        
    }
    
    
    
    public String RecieveOracle(ArrayList <Player> myarray){
     int oracleindex = -3;
     String emailtester ="hi";
     String emailmessage ="hi";
     String name = null;
     
        for(int k=0; k<myarray.size(); k++){
            if(myarray.get(k).oracle){
                oracleindex = k;
            }
        }
        
        if(oracleindex >=0 && myarray.get(oracleindex).living){
          //get mail here and return email message and emailer
          if(emailtester.equals(myarray.get(oracleindex).email)){
                for(int n=0; n<myarray.size(); n++){
                    if(emailmessage.equals(myarray.get(n).name)){
                        name = myarray.get(n).name;
                    }
                }
            }
        }
        return name;
    }
    
    
    
    
    
    
    
   public String RecieveWere(ArrayList <Player> myarray){
     int werewolfindex = -3;
     String emailtester ="hi";
     String emailmessage ="hi";
     String name = null;
     
        for(int k=0; k<myarray.size(); k++){
            if(myarray.get(k).werewolf){
                werewolfindex = k;
            }
        }
        
        if(werewolfindex >=0 && myarray.get(werewolfindex).living){
          //get mail here and return email message and emailer
          if(emailtester.equals(myarray.get(werewolfindex).email)){
                for(int m=0; m<myarray.size(); m++){
                    if(emailmessage.equals(myarray.get(m).name)){
                        name = myarray.get(m).name;
                    }
                }
            }
        }
        return name;
   }
    
    
    
    
   public void RecieveVotes(ArrayList <Player> myarray){
        //return last recieved email thats unread
        //check it if it's a players name
        String nameemail = "name";
        String message = "hello";
        int numemails=0;
        int numplayers = NumberofLivinghumanplayers(myarray);
        
    while(numemails != numplayers){
        for(int i=0; i<=myarray.size(); i++){
            if(nameemail.equals(myarray.get(i).email) && myarray.get(i).living){//if we have a player response
                
            
            for(int j=0; j<myarray.size(); j++)
                 if(message.contains(myarray.get(j).name)){ //that person voted for...??
                     myarray.get(i).voted = false; //turn their voted to true
                     myarray.get(j).votevalue++;
                     numemails++;
                 }
                 else{
                     //SEND THEM A MESSAGE FOR INVALID INPUT
                 }
            }
       }
    }
        
 
   }
    
    
    
   void SendAllMessages(ArrayList <Player> myarray, String messager){
        String thisPersonsEmail;
        String Message = messager;
        for(int o=0; o<myarray.size(); o++){
            thisPersonsEmail = myarray.get(o).email;
            //SendMessage(thisPersonsEmail, Message);
        }        
    }  
    
    
    
    int NumberofLivinghumanplayers(ArrayList <Player> myarray){
        int numplayers=0;
        
        
        for(int h=0; h<myarray.size(); h++){
            if(myarray.get(h).email != null){
                if(myarray.get(h).living){
                    numplayers++;
                }
            }
        }
        
        
        return numplayers;
    }
    
    
    
    }
    
    
    
    
    
        
        
   
    
    
    
    
    
    
    
    
    
    
    

