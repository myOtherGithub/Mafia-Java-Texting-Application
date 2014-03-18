/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werewolfgamenontexting;

import java.lang.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author CHaDOS
 */
class Registration {

    void register(ArrayList<Player> myarray) {
        Scanner keyboard = new Scanner(System.in);
        String command = keyboard.nextLine();
        String ender = "end";

        while (!"end".equals(command)) {

            boolean aion;
            String playerdatainput = keyboard.nextLine();
            if (playerdatainput.equals(ender)) {
                if (myarray.size() <= 5) {
                    command = "ckae";
                } else {
                    command = ender;
                }
            } else {

                String[] playerdata = playerdatainput.split("\\s*,\\s*");
                if (playerdata.length < 3) {
                    String name = playerdata[0];
                    myarray.add(new Player(name));
                    System.out.println("added " + name + " to the game");
                } else {
                    String name = playerdata[0];
                    String email = playerdata[1];
                    String booleanai = playerdata[2];

                    if (booleanai.equals("false")) {
                        aion = false;
                    } else {
                        aion = true;
                    }

                    myarray.add(new Player(name, email, aion));
                    System.out.println("added " + name + " to the game");
                }
            }
        }

        Random myrandom = new Random();
        int random1 = myrandom.nextInt(myarray.size());
        int therandom = myrandom.nextInt(myarray.size());

        while (therandom == random1) {
            therandom = myrandom.nextInt(myarray.size());
        }

        myarray.get(random1).bestowOracle();
        myarray.get(therandom).bite();
        System.out.println(myarray.get(random1).name);
        System.out.println(myarray.get(therandom).name);


    }
    
    
   
    
    
    
    
    
    
    
    
    
    
}
