import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n=0,idx=0;
        ArrayList<Integer> arr=new ArrayList<>();
        
        while(n<progresses.length) {
        	boolean flag=true;
        	int cnt=0;
        	for(int i=idx;i<progresses.length;i++) {
        		progresses[i]+=speeds[i];
        		if(flag&&progresses[i]>=100) {
        			cnt++;
        			n++;
                    idx++;
        		}
        		else {
        			flag=false;
        		}
        	}
            if(cnt!=0)arr.add(cnt);
        }
        int answer[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++) {
        	answer[i]=arr.get(i);
        }
        return answer;
    }
}