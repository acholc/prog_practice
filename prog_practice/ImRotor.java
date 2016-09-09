import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ImRotor{
    //Handles (90deg) rotation of NxN matrix image with 4-byte pixels
    //private int sz;   //internal representation of NxN
    
    private static int[][] rotate(int[][] in, int sz){
        //1. Put image in 1D array and pop h-distance elements into new array
        //2. Use indices to swap elements
        //Proceed by row(i). In each successive row begin column indices from i+1
        
        for (int i = 0; i < sz; i++){
            for (int j = i+1; j < sz; j++){
                //can ignore (i,i) index since it flips to same place
                int tmp = in[i][j];
                in[i][j] = in[j][i];
                in[j][i] = tmp;
            }
        }
        
        for (int i = 0; i < sz ; i++){
            for (int j = 0; j < sz/2; j++){
                //can ignore (i,i) index since it flips to same place
                int tmp = in[i][j];
                in[i][j] = in[i][sz-1-j];
                in[i][sz-1-j] = tmp;
            }
        }
        
        return in;
    }
    
    //public int getSize(int)
    public static void main(String[] args){
        
        int N = Integer.parseInt(args[1]);
        int[][] img = new int[N][N];
        int i = 0;
        
        try{
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line= scanner.nextLine();
                String[] linesplit = line.split(" ");
                //int[] nextrow = new int[linesplit.length()];
                for(int j = 0; j < linesplit.length; j++)
                    img[i][j]  = Integer.parseInt(linesplit[j]);
                i+=1;
            }
            scanner.close();
        } catch(FileNotFoundException e){
            System.err.println("Error reading from file: " + e.getMessage());
            System.exit(0);
        }
        
        int[][] out = rotate(img,N);
        for (int j=0; j<N; j++){
            for (int k = 0; k < N; k++){
                System.out.print(out[j][k]+" ");
            }
            System.out.println("\n");
        }
        
    }
}