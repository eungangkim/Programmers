import java.util.ArrayDeque;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
		int crossingTruck=0,nextTruck=0,currentWeight=0,length=truck_weights.length,time=0;
		ArrayDeque<Integer> timeStamp=new ArrayDeque<>();

		while(crossingTruck<length) {
			time++;
			if(!timeStamp.isEmpty()&&time-timeStamp.peek()==bridge_length) {
				currentWeight-=truck_weights[crossingTruck++];
                timeStamp.poll();
			}
			if(nextTruck<length&&currentWeight+truck_weights[nextTruck]<=weight&&nextTruck-crossingTruck<bridge_length) {
				currentWeight+=truck_weights[nextTruck++];
                timeStamp.add(time);
			}
		}
		
		return time;
	}
}