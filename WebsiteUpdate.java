/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package werewolfgamenontexting;

/**
 * @author CHaDOS
 */

import java.io.*;

public class WebsiteUpdate {

   void main(String[] args) {

        try {
            String str = "Asssholeeeee";
            File newTextFile = new File("C:/thetextfile.txt");

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(str);
            fw.close();
        } catch (IOException iox) {
            
        }
    }
    
    
 String readFile(String filename) {
   String content = null;
   File file = new File(filename); //for ex foo.txt
   try {
       FileReader reader = new FileReader(file);
       char[] chars = new char[(int) file.length()];
       reader.read(chars);
       content = new String(chars);
       reader.close();
   } catch (IOException e) {
       e.printStackTrace();
   }
   return content;
}
    
    
    
}