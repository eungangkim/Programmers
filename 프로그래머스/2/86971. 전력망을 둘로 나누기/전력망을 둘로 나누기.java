import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int[][] wires) {
		boolean [][]map=new boolean[n][n];
		initMap(map,wires);
		return getMinDiffByEdgeSplit(map);
	}
	public void initMap(boolean [][]map,int[][]wires) {
		for(int i=0;i<wires.length;i++) {
			map[wires[i][0]-1][wires[i][1]-1]=true;
			map[wires[i][1]-1][wires[i][0]-1]=true;
		}
	}
	public int getMinDiffByEdgeSplit(boolean [][]map) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<map.length;i++) {
			ArrayList<Integer> numOfNodes=new ArrayList<>();
			int sum=initNumOfNodes(numOfNodes,map,i)+1;
			for(int j=0;j<numOfNodes.size();j++) {
				min=Math.min(min, Math.abs(sum-numOfNodes.get(j)*2));
			}
		}
		return min;
	}
	public int initNumOfNodes(ArrayList<Integer> numOfNodes,boolean [][]map,int k) {
		int sum=0;
		
		for(int i=0;i<map.length;i++) {
			if(!map[k][i])continue;
			int cnt=1;
			boolean []visited=new boolean[map.length];
			PriorityQueue<Integer> queue=new PriorityQueue<>();
			visited[k]=true;
			visited[i]=true;
			queue.add(i);
			while(!queue.isEmpty()) {
				int node=queue.poll();
				for(int j=0;j<map.length;j++) {
					if(!visited[j]&&map[node][j]) {
						visited[j]=true;
						queue.add(j);
						cnt++;
					}
				}
			}
			numOfNodes.add(cnt);
			sum+=cnt;
		}
		return sum;
	}
}