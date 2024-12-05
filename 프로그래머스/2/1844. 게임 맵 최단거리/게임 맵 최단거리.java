import java.util.ArrayDeque;
class Solution {
    public int solution(int[][] maps) {
		boolean [][]visited=new boolean[maps.length][maps[0].length];
		ArrayDeque<int []> queue=new ArrayDeque<>();
		int []dr= {1,0,-1,0};
		int []dc= {0,1,0,-1};
		
		queue.add(new int[] {0,0,1});
		visited[0][0]=true;
		
		while(!queue.isEmpty()) {
			int info[]=queue.poll();
			if(info[0]==maps.length-1&&info[1]==maps[0].length-1)return info[2];
			
			for(int i=0;i<4;i++) {
				int r=info[0]+dr[i],c=info[1]+dc[i];
				
				if(0<=r&&r<maps.length&&0<=c&&c<maps[0].length&&maps[r][c]==1&&!visited[r][c]) {
					visited[r][c]=true;
					queue.add(new int[] {r,c,info[2]+1});
				}
			}
		}
		return -1;
	}
}