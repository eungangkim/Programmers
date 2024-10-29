import java.util.*;

class Solution {
    public int solution(int[] cards) {
		PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
		for(int i=0;i<cards.length;i++) {
			int boxCount=0;
			int j=i;
			while(cards[j]!=0) {
				int temp=j;
				boxCount++;
				j=cards[j]-1;
				cards[temp]=0;
			}
			queue.add(boxCount);
		}
		return queue.size()<2?0:queue.poll()*queue.poll();
	}
}