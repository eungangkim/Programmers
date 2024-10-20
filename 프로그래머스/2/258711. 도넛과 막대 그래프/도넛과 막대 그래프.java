import java.util.ArrayDeque;
import java.util.HashMap;
class Solution {
   public int[] solution(int[][] edges) {
		int []answer=new int[4];
		int []out=new int[1000000];
		int max=0;
		boolean []visited=new boolean[1000000];
    	ArrayDeque<Integer> headVertex=new ArrayDeque<>();	

		for(int []edge:edges) {
			out[edge[0]-1]++;
			visited[edge[1]-1]=true;
			headVertex.add(edge[0]-1);
			max=Math.max(max, Math.max(edge[0], edge[1]));
		}
		
		while(!headVertex.isEmpty()) {
			int vertex=headVertex.poll();
			if(!visited[vertex]&&out[vertex]>=2) {
				answer[0]=vertex+1;
				break;
			}
		}
		answer[1]=out[answer[0]-1];
		for(int i=0;i<max;i++) {
			if(out[i]==0&&visited[i]) {
				answer[2]++;
				answer[1]--;
			}
			else if(out[i]==2&&visited[i]) {
				answer[3]++;
				answer[1]--;
			}
		}
		return answer;
	}
}