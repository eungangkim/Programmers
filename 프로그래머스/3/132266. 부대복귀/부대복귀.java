import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    ArrayList<Integer> graph[];
	int shortestTimeToDestination[];
	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		shortestTimeToDestination=new int[n];
		initGraph(n,roads);
		
		bfs(n,destination-1);
		
		return getShortestTimeFrom(destination,sources);
	}
	public void initGraph(int n,int[][] roads) {
		graph=new ArrayList[n];
		for(int i=0;i<roads.length;i++) {
			int area1=roads[i][0]-1,area2=roads[i][1]-1;
			if(graph[area1]==null)graph[area1]=new ArrayList<>();
			if(graph[area2]==null)graph[area2]=new ArrayList<>();
			graph[area1].add(area2);
			graph[area2].add(area1);
		}
	}
	public void bfs(int n,int destination) {
		boolean visited[]=new boolean[n];
		ArrayDeque<int []> queue=new ArrayDeque<>();
		
		queue.add(new int[] {destination,0});
		visited[destination]=true;
		
		while(!queue.isEmpty()) {
			int info[]=queue.poll();
			shortestTimeToDestination[info[0]]=info[1];
			for(int to:graph[info[0]]) {
				if(!visited[to]){
                    queue.add(new int[] {to,info[1]+1});
                    visited[to]=true;
                }			}
		}
	}
	public int[] getShortestTimeFrom(int destination,int[] sources) {
		int shortestTime[]=new int[sources.length];
		for(int i=0;i<sources.length;i++) {
			if(shortestTimeToDestination[sources[i]-1]==0&&sources[i]!=destination)shortestTime[i]=-1;
			else shortestTime[i]=shortestTimeToDestination[sources[i]-1];
			
		}
		return shortestTime;
	}
}