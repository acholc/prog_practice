import java.util.*;
import java.lang.Math;

//More efficient O(n) solution exists by moving l-r and putting "still supported" 
//buildings (i.e. ones for whom we have not encountered a shorter one) in a stack
public class LargestSkyline{
	
	static int[] skyline;
	static int max_;

	public static void main(String[] args){
		
		int N = args.length;
		skyline = new int[N];
		
		for(int i = 0; i < N; i++){
			skyline[i] = Integer.parseInt(args[i]);
		}
		
		max_ = skyline[0]; //Integer.MIN_VALUE;
		int minHeight = skyline[0]; //Integer.MAX_VALUE;
		int minHeightIdx = 0;
		
		for(int i = 1; i < N; i++){
			if(skyline[i] < minHeight){
				minHeight = skyline[i];
				minHeightIdx = i;
				if(skyline[i]*(i+1) > max_) max_ = skyline[i]*(i+1);
			}
			/*else if(skyline[i] <= skyline[i-1]){
				int j = i-1;
				int tmp_max = skyline[i];
				while(j > -1 && skyline[j] >= skyline[i]){
					tmp_max += skyline[i];
					j--;
				}
				if(tmp_max > max_) max_ = tmp_max;
			}*/
			else{
				int j = i-1;
				int tmp_max = skyline[i];
				int tmp_min = tmp_max;
				while(j > minHeightIdx){
					if(skyline[j] < tmp_min){
						tmp_min = skyline[j];
					}
					tmp_max = tmp_min*(i-j+1);
					j--;
				}
				if(tmp_max > max_) max_ = tmp_max;
				if(skyline[i] > max_) max_ = skyline[i];
			}
			if(minHeight*(i+1) > max_) max_ = minHeight*(i+1);
		}
		
		/*int maxd = Integer.MIN_VALUE;
		int min_ = Integer.MAX_VALUE;
		int min_idx = 0;
		
		for(int i = 0; i < N; i++){
			if(skyline[i] < min_){
				min_ = skyline[i];
				min_idx = i;
			} 
			int tmp_max = getMaxRectangle(i,min_idx,min_);
			if(tmp_max > maxd) maxd = tmp_max;
		}*/
		
		System.out.println(max_);
		//System.out.println(Arrays.toString(max_));
		
	}
	
	/*
	static int getMaxRectangle(int i, int midx, int min_){
		
		int min_max = 0;
		if(skyline[i] == min_) min_max = min_*(i+1);
		
		for(int k = midx;  k <= i; k++){
			int t = 0;
			for(int j = k; (skyline[j] >= skyline[k]) && j <= i; j++){
				t += skyline[k];
			}
			if(t > min_max) min_max = t;
		}
		
		max_[i] = (i > 0)? Math.max(skyline[i], 
					Math.max(max_[i-1], min_max)): skyline[i];
		return max_[i];
	}
	*/
}