import java.util.*;

public class MajorityElement{
    
    
    
    public static void main(String[] args){
        
        char candidate = args[0].toCharArray()[0];;
        int candidateCount = 1;
        for(int i = 1; i < args.length; i++){
            char tmp = args[i].toCharArray()[0];
            if(candidateCount == 0){
                candidate = tmp;
                candidateCount++;
            } 
            else if(candidate != tmp) candidateCount--;
            else candidateCount++;
        }
        
        System.out.println(candidate);
    }
}