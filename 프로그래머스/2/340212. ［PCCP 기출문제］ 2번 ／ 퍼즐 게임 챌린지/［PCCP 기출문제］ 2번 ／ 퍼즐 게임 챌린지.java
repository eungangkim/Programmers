
import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
		int low=1;
		int high=100000;
		while(low<=high) {
			int middle=(low+high)/2;
			long totalTime=times[0];
            
			for(int i=1;i<diffs.length;i++) {
				totalTime+=times[i];
				if(diffs[i]>middle)
					totalTime+=(diffs[i]-middle)*(times[i]+times[i-1]);
			}
		    if(totalTime==limit)return middle;
            else if(totalTime<limit)high=middle-1;
			else if(totalTime>limit)low=middle+1;
		}
		return low;
	}
}