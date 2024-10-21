import java.util.PriorityQueue;

class Solution {
   public int solution(int[][] targets) {
		PriorityQueue<int []> queue=new PriorityQueue<>((a,b)->a[0]-b[0]);
		int answer=1;
		int rocket;
		for(int target[]:targets)
			queue.add(target);
		rocket=queue.poll()[1];
		while(!queue.isEmpty()){
			int target[]=queue.poll();
			if(rocket<=target[0]) {
				rocket=target[1];
				answer++;
			}
            if(rocket>target[1])
                rocket=target[1];
		}
		return answer;
	}
}