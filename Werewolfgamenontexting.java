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
        
        ArrayList<Player> myarray = new ArrayList();
        Registration initialize = new Registration();
        initialize.register(myarray);
        ReturnNewestMessage cake = new ReturnNewestMessage();
        ArrayList<MessageTracker> messages = cake.returnmessage2(myarray);
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
                System.out.println("Upon waking up you have found that your beloved mayor has been found dead");
                death = newvote.CompleteVoting(myarray);
                if(death != -2){
                    deathcounter+=1;
                }
                day = false;
                twelvehourperiod++;
                
            } else {
                System.out.println("The sun has just risen on day "+twelvehourperiod );
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
            if (oracleindex >= 0) {
                myarray.get(oracleindex).oracleaction(myarray);
                day = true;
            }
            if (wereindex >= 0) {
                death = myarray.get(wereindex).werewolfaction(myarray);
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
    
    
    
    
}


