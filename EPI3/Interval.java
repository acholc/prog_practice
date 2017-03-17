import java.util.*;

//First attempt. Requires sorted input
public class Interval{
    
    private static List<List<Integer>> interval = new ArrayList<>();
    private static Deque<Integer> res = new ArrayDeque<>();
    
    public static void main(String[] args){
        
        //parse input
        String in;
        String[] ins = new String[2];
        for(int i = 0; i < args.length; i++){
            if(!args[i].substring(0,1).equals("[")){
                System.out.println("Invalid input format");
                return;
            }
            in = args[i].substring(1,args[i].length()-1);
            ins = in.split(",");
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(Integer.parseInt(ins[0]));
            tmp.add(Integer.parseInt(ins[1]));
            interval.add(tmp);
        }
        
        //extract covering set
        int  j = interval.size()-1;
        res.addFirst(interval.get(j).get(0));
        while(j > 0){
            j--;
            if(interval.get(j).get(1) < res.peekFirst()){
                res.addFirst(interval.get(j).get(0));
            }
        }
        
        //display
        for(int i: res){
            System.out.println(i + " ");
        }
    }

}