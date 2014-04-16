/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werewolfgamenontexting;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class Voting {
ReturnNewestMessage eturner = new ReturnNewestMessage();


 void voting(ArrayList <Player> myarray){
  Scanner keyboard = new Scanner(System.in);
    //String command = keyboard.nextLine();
  ArrayList<MessageTracker> messages;
    String ender = "end";
    boolean votingincomplete = true;
    
    for(Player voteplayer : myarray){
        if(!voteplayer.living){
          voteplayer.voted= true;
      }
    }
    
    for(int i=0; i<myarray.size(); i++){
        if(myarray.get(i).living && myarray.get(i).computer){ //person is living and a computer
                    myarray.get(i).voted = true;
                    Random thisrandom = new Random();
                    int votedfor = thisrandom.nextInt(myarray.size());
                    while(!myarray.get(votedfor).living){
                        votedfor = thisrandom.nextInt(myarray.size());
                    }
                    myarray.get(votedfor).addvote();
                     System.out.println(myarray.get(i).name + " voted for " + myarray.get(votedfor).name);
                
          }
    }
    
  for(int j = 0;j < myarray.size(); j++){
      if(myarray.get(j).living && !myarray.get(j).computer && !myarray.get(j).voted){ //living and not a computer
          while(votingincomplete){  
            GetAllVotes(myarray);
            votingincomplete = EverybodyVoted(myarray);
        }    
    }
  }  
    
} //end of main constructor
 

 //calculates the totals of everyone in the game
int CalculateTotal(ArrayList <Player> myarray){
    int highest = 0;
    int highestindex = -2;
    for(int i=0; i<myarray.size(); i++){
        if(myarray.get(i).votetotal() > highest){
            highest = myarray.get(i).votetotal();
            highestindex = i;
        }
    }
    if(highest == 0 || highest == 1){
        return -1;
    }
    else{
        return highestindex;
    }
  }


//finishes the voting and determines the winner
int CompleteVoting(ArrayList <Player> myarray){
    SendMessage thismessage = new SendMessage();
    voting(myarray);
    int winner = CalculateTotal(myarray);
    if(winner == -1){
        //nobody won
        thismessage.sendAll(myarray, "no one is to be exiled");
        System.out.println("no one is to be exiled");
        WipeVotes(myarray);
    }else{
        thismessage.sendAll(myarray, myarray.get(winner).name + " was exiled from the village");
        System.out.println(myarray.get(winner).name + " was exiled from the village");
        myarray.get(winner).Kill();
        WipeVotes(myarray);
    }
     return winner;
    
}


//wipes the votes at the end
void WipeVotes(ArrayList <Player> myarray){
    for(int i=0; i<myarray.size(); i++){
        myarray.get(i).votevalue = 0;
        myarray.get(i).voted = false;
    }
}

void GetAllVotes(ArrayList<Player> myarray){
            ArrayList<MessageTracker> messages;
            messages = eturner.returnmessage2(myarray);
            for(MessageTracker thismessage : messages){
              
             for(Player playervoting : myarray){   
                if(playervoting.name.contains(thismessage.name) && playervoting.living){
                    if(thismessage.message.startsWith("/vote")){
                        if(thismessage.message.contains("no one")){
                                    playervoting.voted = true;
                        }else{
                         for(Player thisplayer : myarray){
                            if((thismessage.message.contains(thisplayer.name)) && thisplayer.living){
                                  System.out.println(playervoting.name + " voted for " + thisplayer.name);
                                  thisplayer.addvote();
                                  playervoting.voted = true;
                            }
                         }
                        }
                      }
                   }
                }       
         }
}


boolean EverybodyVoted(ArrayList <Player> myarray){
    int counter1=0;
   for(Player thisplayer : myarray){
       if(thisplayer.voted){
           counter1++;
       }
   }
   
   if(counter1 == myarray.size()){
       return false;
   }
   else{
       return true;
   }
}


}

