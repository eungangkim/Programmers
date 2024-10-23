import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
		ArrayDeque<int []> queue=new ArrayDeque<>();
		
		queue.add(new int[]{y,0});
		while(!queue.isEmpty()) {
			int []info=queue.poll();
			if(info[0]==x)return info[1];
			if(info[0]%2==0&&info[0]/2>=x)queue.add(new int[] {info[0]/2,info[1]+1});
			if(info[0]%3==0&&info[0]/3>=x)queue.add(new int[] {info[0]/3,info[1]+1});
			if(info[0]-n>=x)queue.add(new int[] {info[0]-n,info[1]+1});
		}
		return -1;
	}
}