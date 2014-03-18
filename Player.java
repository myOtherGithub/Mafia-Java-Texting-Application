/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werewolfgamenontexting;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author CHaDOS
 */
class Player {

    boolean living;
    int votevalue;
    boolean voted;
    String name;
    String email;
    boolean werewolf;
    boolean oracle;
    boolean computer;

    boolean isAlive() {
        if (living) {
            return true;
        } else {
            return false;
        }
    }

    boolean isWerewolf() {
        if (werewolf) {
            return true;
        } else {
            return false;
        }
    }

    boolean isOracle() {
        if (oracle) {
            return true;
        } else {
            return false;
        }
    }

    void bestowOracle() {
        oracle = true;
    }

    void bite() {
        werewolf = true;
    }

    void Kill() {
        if (living == true) {
            living = false;
        }
    }

    int votetotal() {
        return votevalue;
    }

    Player(String playerName, String playerEmail, boolean AI) {
        name = playerName;
        email = playerEmail;
        living = true;
        votevalue = 0;
        werewolf = false;
        oracle = false;
        computer = AI;
        voted = false;
    }

    Player(String playerName) {
        name = playerName;
        email = null;
        living = true;
        votevalue = 0;
        werewolf = false;
        oracle = false;
        computer = true;
        voted = false;
    }

    void addvote() {
        votevalue += 1;
    }

    void clearvote() {
        votevalue = 0;
    }

    //the special villager functions are found below
    
    ///////////////////////////////////////////
    // WEREWOLF FUNCTION
    //////////////////////////////////////////
    
    int werewolfaction(ArrayList<Player> victimarray) {
        int deadornot = -2;
        boolean VictimChoiceIncomplete = true;
        if (werewolf && !computer) { //If the player is a human
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Congratulations werewolf, who would you like to bite tonight?");
            while (VictimChoiceIncomplete) {
                String victim = keyboard.nextLine();
                for (int j = 0; j < victimarray.size(); j++) {
                    if (victim.equals(victimarray.get(j).name) && victimarray.get(j).living) {
                        victimarray.get(j).Kill();
                        VictimChoiceIncomplete = false;
                        deadornot = 1;
                    } else if (victim.equals(victimarray.get(j).name) && !victimarray.get(j).living) {
                        System.out.println("You cannot kill the dead");
                        
                    }
                    else if(victim.equals("no one")){
                        deadornot =-2;
                        System.out.println("You have decided not to kill anyone.");
                    }
                }
            }
        } else if (werewolf && computer) { //If the player is a random player

            Random thisrandom = new Random();
            int victim = thisrandom.nextInt(victimarray.size());
            while (!victimarray.get(victim).living) { //while victim isnt living
                victim = thisrandom.nextInt(victimarray.size()); //go to the next random and set them as random
            }
            victimarray.get(victim).Kill();
            System.out.println(victimarray.get(victim).name + " was found dead with bite and claw marks" );
            deadornot = 1;

        } else {//If they're not even a werewolf?!
        }
        return deadornot;
    }

    ///////////////////////////////////////////
    // ORACLE FUNCTION
    //////////////////////////////////////////
    
    void oracleaction(ArrayList<Player> victimarray) {
        boolean VictimChoiceIncomplete = true;
        if (oracle && !computer && living) { //If the player is a living human
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Use your powers to look at someone and see if they are the werewolf or not!");
            while (VictimChoiceIncomplete) {
                String victim = keyboard.nextLine();
                for (int j = 0; j < victimarray.size(); j++) {
                    if (victim.equals(victimarray.get(j).name) && victimarray.get(j).living) {
                        if(victimarray.get(j).werewolf){
                            System.out.println("You have decided to look at "+ victimarray.get(j).name +" and they are the werewolf");
                        }else if(victimarray.get(j).oracle){
                            System.out.println("You have decided to look at "+ victimarray.get(j).name +"and they are... you?");
                        }else{
                            System.out.println("You have decided to look at "+ victimarray.get(j).name +"and they are a normal villager!");   
                        }
                        VictimChoiceIncomplete = false;
                    } else if (victim.equals(victimarray.get(j).name) && !victimarray.get(j).living) {
                        System.out.println("You cannot read the minds of the dead...");
                    }
                }
            }
        }if (oracle && computer) { //If the player is a random player
        } else {//If they're not even an oracle?!
        }
    }
}
