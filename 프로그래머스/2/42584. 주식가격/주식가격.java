import java.util.PriorityQueue;
class Solution {
    public int[] solution(int[] prices) {
		PriorityQueue<int []> queue=new PriorityQueue<>((a,b)->b[0]-a[0]);
		int length=prices.length;
		for(int i=0;i<length;i++) {
			queue.add(new int[] {prices[i],i});
			while(queue.peek()[0]>prices[i]) {
				int []info=queue.poll();
				prices[info[1]]=i-info[1];
			}
			prices[i]=length-1-i;
		}
		return prices;
	}
}