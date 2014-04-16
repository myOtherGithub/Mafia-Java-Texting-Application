package werewolfgamenontexting;

import java.util.ArrayList;

/**
 *
 * @author CHaDOS
 */
public class Werewolfgamenontexting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SendMessage sender = new SendMessage();
        ArrayList<Player> myarray = new ArrayList();
        Registration initialize = new Registration();
        initialize.register(myarray);
        ReturnNewestMessage cake = new ReturnNewestMessage();
        ArrayList<MessageTracker> messages;
        //SendMessage sender = new SendMessage();
        //sender.sendMessage("hello");
   //     RecieveResponses- = new RecieveResponses();
        

//find the werewolf and oracle
        int oracleindex = -2;
        int wereindex = -2;

        for (int i = 0; i < myarray.size(); i++) {
            if (myarray.get(i).werewolf) {
                wereindex = i;
            } else if (myarray.get(i).oracle) {
                oracleindex = i;
            } else {
            }
        }

        
        int twelvehourperiod = 0;
        Voting newvote = new Voting();
        boolean day = true;
        int death=0;
        int deathcounter = 0;
        boolean win = false;


        while(deathcounter != myarray.size() && win == false){
        if (day) {
            if (twelvehourperiod == 0) {
                
                String listofplayers="";
                for(Player thisplayer : myarray){
                     if(thisplayer.living){
                        listofplayers += thisplayer.name + " ,";
                      }
               }
        
                if(listofplayers.endsWith(",")){
                         listofplayers = listofplayers.substring(0, listofplayers.length()-1);
                 }
             
                sender.sendAll(myarray,"In the square your mayor is clawed to death. Villagers exile the werewolf. Send /vote <name> to vote.");
                sender.sendAllLiving(myarray, "Here is a list of living players: " + listofplayers);
                
                
                death = newvote.CompleteVoting(myarray);
                if(death != -2){
                    deathcounter+=1;
                }
                day = false;
                twelvehourperiod++;
                
            } else {
                sender.sendAll(myarray,"The sun has just risen on day "+twelvehourperiod +" Send /vote <name> to vote.");
                
                String listofplayers="";
                for(Player thisplayer : myarray){
                     if(thisplayer.living){
                        listofplayers += thisplayer.name + " , ";
                      }
               }
        
                if(listofplayers.endsWith(",")){
                         listofplayers = listofplayers.substring(0, listofplayers.length()-1);
                 }
             
                sender.sendAllLiving(myarray, "Here is a list of living players: " + listofplayers);
                System.out.println("The sun has just risen on day "+twelvehourperiod + " " + listofplayers);
                death = newvote.CompleteVoting(myarray);
                if(death != -2){
                    deathcounter+=1;
                }
                day = false;
                twelvehourperiod++;
            }
            
            
            
      boolean werewin = false;
      int werewolfindex = -2;
      
      for(int i=0; i<myarray.size(); i++){
          if(myarray.get(i).isWerewolf()){ //if the werewolf is still alive
              werewolfindex = i;
              if(myarray.get(i).living){
                werewin = true;
              }
          }
          if(i == myarray.size()-1){
              if(werewin==false){
                  System.out.println("Upon killing " + myarray.get(werewolfindex).name + " it was found they were the werewolf. The villagers have prevailed!");
                  win = true;
              }
          }
      }            
            
            
            
            
            
            
            
            
            
            
            
        } else {
            System.out.println("Under the cover of darkness, the villagers head back to their homes, while the occult rises and gets to work.");
            sender.sendAll(myarray,"Under the cover of darkness, the villagers head back to their homes, while the occult rises and gets to work.");
            if (oracleindex >= 0) {
                myarray.get(oracleindex).oracleaction(myarray, sender, cake);
                day = true;
            }
            if (wereindex >= 0) {
                death = myarray.get(wereindex).werewolfaction(myarray, sender, cake);
                if(death != -2){
                    deathcounter+=1;
                }
                day = true;
            }
         }
      }
        
        


  //  boolean werewin = false;
  //  int werewolfindex = -2;
  //    
  //    for(int i=0; i<myarray.size(); i++){
  //        if(myarray.get(i).isWerewolf()&& myarray.get(i).living){
  //            werewin = true;
  //            werewolfindex = i;
  //        }
  //        if(i == myarray.size()-1){
  //            if(werewin==false){
  //                System.out.println("The werewolf has won");
  //            }
  //            else{
  //                System.out.println("Upon killing " + myarray.get(i).name + " it was found he was the werewolf. The villagers have prevailed!");
  //            }
  //        }
  //    }
      
     
        
      boolean werewin = false;
      int werewolfindex = -2;
      
      for(int i=0; i<myarray.size(); i++){
          if(myarray.get(i).isWerewolf()){ //if the werewolf is still alive
              werewolfindex = i;
              if(myarray.get(i).living){
                werewin = true;
              }
          }
          if(i == myarray.size()-1){
              if(werewin==false){
                  System.out.println("Upon killing " + myarray.get(werewolfindex).name + " it was found they were the werewolf. The villagers have prevailed!");
                  win = true;
              }
          }
      }    
  }
    
    
    
    boolean Daykeeper(int twelvehourperiod){
        if (twelvehourperiod % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    String LivingPlayerList(ArrayList<Player> players){
        String localstring ="";
        for(Player thisplayer : players){
            if(thisplayer.living){
              localstring += thisplayer.name + " , ";
            }
        }
        
        if(localstring.endsWith(",")){
                     localstring = localstring.substring(0, localstring.length()-1);
        }
        
        return localstring;
    }
    
}


