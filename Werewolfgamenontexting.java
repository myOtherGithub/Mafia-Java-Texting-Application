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

//find the werewolf and oracle
int oracleindex=-2;
int wereindex=-2;
        
for(int i=0; i< myarray.size(); i++){
    if(myarray.get(i).werewolf){
        wereindex = i;
    }
    else if(myarray.get(i).oracle){
        oracleindex = i;
    }
    else{
        
    }
}
        
        
int twelvehourperiod = 0;
Voting newvote = new Voting();
newvote.CompleteVoting(myarray);

boolean day;
if(twelvehourperiod % 2 == 0){
    day = true;
}
else{
    day = false;
}



if(day){
    if(twelvehourperiod == 0){
        System.out.println("Upon waking up you have found that your beloved mayor has been found dead");
        newvote.CompleteVoting(myarray);
        twelvehourperiod++;
    }else{
        System.out.println("The sun has just risen");
    }
}else{
    if(oracleindex >=0){
    myarray.get(oracleindex).oracleaction(myarray);
    System.out.println("The sun has just risen");
    out of the life
            poop;
    }
    if(wereindex >=0){
    myarray.get(wereindex).werewolfaction(myarray);
    }
       
}
        
        
        
    }
}
