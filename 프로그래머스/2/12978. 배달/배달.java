
class Solution {
    public int solution(int N, int[][] road, int K) {
		int graph[][]=new int[N][N];
		int count=1;
		
		for(int i=0;i<road.length;i++) {
			graph[road[i][0]-1][road[i][1]-1]=graph[road[i][0]-1][road[i][1]-1]==0?road[i][2]:Math.min(graph[road[i][0]-1][road[i][1]-1],road[i][2]);
            graph[road[i][1]-1][road[i][0]-1]=graph[road[i][1]-1][road[i][0]-1]==0?road[i][2]:Math.min(graph[road[i][1]-1][road[i][0]-1],road[i][2]);
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int direct=graph[i][j]==0?500001:graph[i][j];
					int via=(graph[i][k]==0?500001:graph[i][k])+(graph[k][j]==0?500001:graph[k][j]);
					graph[i][j]=Math.min(direct, via);
					graph[j][i]=Math.min(direct, via);
				}
			}
		}
		
		for(int i=1;i<N;i++) {
			if(graph[0][i]<=K)count++;
		}
		
		return count;
	}
}