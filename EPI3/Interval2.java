import java.util.*;

public class Interval2{
    
    private static List<Integer>[] interval;
    private static Deque<Integer> res = new ArrayDeque<>();
    
    public static void main(String[] args){
        
        if(args.length == 0) return;
        
        interval = new ArrayList[args.length];
       
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
            interval[i] = tmp;
        }
        
        //sort
        Arrays.sort(interval, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> a, List<Integer> b){
				if(a.get(0).compareTo(b.get(0)) == 0){
				    if(a.get(1)> b.get(1)) return 1;
				    else if(a.get(1) < b.get(1)) return -1;
				    else return 0;
				}
				else if(a.get(0).compareTo(b.get(0)) > 0) return 1;
				else return -1;
			}
        });
        
        //extract covering set
        int  j = interval.length-1;
        res.addFirst(interval[j].get(0));
        while(j > 0){
            j--;
            if(interval[j].get(1) < res.peekFirst()){
                res.addFirst(interval[j].get(0));
            }
        }
        
        //display
        for(int i: res){
            System.out.println(i + " ");
        }
    }

}