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
    }

    Player(String playerName) {
        name = playerName;
        email = null;
        living = true;
        votevalue = 0;
        werewolf = false;
        oracle = false;
        computer = true;
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
    
    void werewolf(ArrayList<Player> victimarray) {
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
                    } else if (victim.equals(victimarray.get(j).name) && !victimarray.get(j).living) {
                        System.out.println("You cannot kill the dead");
                    }
                }
            }
        } else if (werewolf && computer) { //If the player is a random player

            Random thisrandom = new Random();
            int victim = thisrandom.nextInt(victimarray.size());
            while (!victimarray.get(victim).living) {
                victim = thisrandom.nextInt(victimarray.size());
            }
            victimarray.get(victim).addvote();
            System.out.println(victimarray.get(victim).name + " bit and killed " + victimarray.get(victim).name);

        } else {//If they're not even a werewolf?!
        }
    }

    ///////////////////////////////////////////
    // ORACLE FUNCTION
    //////////////////////////////////////////
    
    void oracle(ArrayList<Player> victimarray) {
        boolean VictimChoiceIncomplete = true;
        if (oracle && !computer) { //If the player is a human
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
        } else if (oracle && computer) { //If the player is a random player
        } else {//If they're not even a werewolf?!
        }
    }
}
