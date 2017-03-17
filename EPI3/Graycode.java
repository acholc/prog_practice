import java.util.*;

public class Graycode{
    
    public int[] code;
    
    public Graycode(int n){
        code = new int[n];
    }
    
    public static void main(String[] args){
        Graycode g = new Graycode(2);
        System.out.println(g.code);
    }

}