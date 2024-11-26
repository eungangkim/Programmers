import java.util.ArrayList;
class Solution {
   public int[] solution(int[] progresses, int[] speeds) {
    	ArrayList<Integer> done=new ArrayList<>();
    	int idx=0,day=0,length=progresses.length;
    	int answer[];
    	
    	while(idx<length) {
    		int start=idx,remain=100-progresses[idx]-day*speeds[idx];
    		day+=remain/speeds[idx]+(speeds[idx]!=1&&remain%speeds[idx]!=0?1:0);
    		while(idx<length&&progresses[idx]+speeds[idx]*day>=100)idx++;
    		done.add(idx-start);
    	}
    	
    	answer=new int[done.size()];
    	
    	for(int i=0;i<answer.length;i++) {
    		answer[i]=done.get(i);
    	}
    	
    	return answer;
    }
}