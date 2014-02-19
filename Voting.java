/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werewolfgamenontexting;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Voting {
  
 void voting(ArrayList <Player> myarray){
  Scanner keyboard = new Scanner(System.in);
    //String command = keyboard.nextLine();
    String ender = "end";
    boolean votingincomplete = true;
    
  for(int i = 0;i < myarray.size(); i++){
      if(myarray.get(i).living && myarray.get(i).computer){
                    
                    Random thisrandom = new Random();
                    int votedfor = thisrandom.nextInt(myarray.size());
                    while(!myarray.get(votedfor).living){
                        votedfor = thisrandom.nextInt(myarray.size());
                    }
                    myarray.get(votedfor).addvote();
                     System.out.println(myarray.get(i).name + " voted for " + myarray.get(votedfor).name);
                
          }
      else if(myarray.get(i).living && !myarray.get(i).computer){
          while(votingincomplete){
          String vote = keyboard.nextLine();
            for(int j=0; j< myarray.size(); j++){
                
                
                if(vote.equals(myarray.get(j).name) && myarray.get(j).living){
                   myarray.get(j).addvote();
                   votingincomplete = false;
                }
                else if(vote.equals(myarray.get(j).name) && !myarray.get(j).living){
                    System.out.println("You voted for a dead guy");
                }
                
                
                
            }
          }
      }
  }  
    
} //end of main constructor
 

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



void CompleteVoting(ArrayList <Player> myarray){
    voting(myarray);
    int winner = CalculateTotal(myarray);
    if(winner == -1){
        //nobody won
        System.out.println("nobody wins");
        WipeVotes(myarray);
    }else{
        System.out.println(myarray.get(winner).name + " lost the game");
        myarray.get(winner).Kill();
        WipeVotes(myarray);
    }
    
}

void WipeVotes(ArrayList <Player> myarray){
    for(int i=0; i<myarray.size(); i++){
        myarray.get(i).votevalue = 0;
    }
}




}
