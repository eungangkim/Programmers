import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
		ArrayDeque<Integer> queue=new ArrayDeque<>();
		int count=0;
		queue.add(y);
		
		while(!queue.isEmpty()) {
			ArrayDeque<Integer> next=new ArrayDeque<>();
			while(!queue.isEmpty()) {
				int number=queue.poll();
				if(number==x)return count;
				if(number%2==0&&number/2>=x)next.add(number/2);
				if(number%3==0&&number/3>=x)next.add(number/3);
				if(number-n>=x)next.add(number-n);
			}
			queue=next;
			count++;
		}
		return -1;
	}
}