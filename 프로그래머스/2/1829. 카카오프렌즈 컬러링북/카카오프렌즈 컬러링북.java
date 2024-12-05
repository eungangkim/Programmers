import java.util.ArrayDeque;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
		int answer[]=new int[2];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(picture[i][j]!=0) {
					answer[0]++;
					answer[1]=Math.max(answer[1],bfs(i,j,picture));
				}
			}
		}
		
		return answer;
	}
	public int bfs(int i,int j,int picture[][]) {
		ArrayDeque<int[]> queue=new ArrayDeque<>();
		int []dr= {1,0,-1,0};
		int []dc= {0,1,0,-1};
		int target=picture[i][j],count=0;
		
		queue.add(new int[] {i,j});
		picture[i][j]=0;
		
		while(!queue.isEmpty()) {
			count++;
			int info[]=queue.poll();
			
			for(int k=0;k<4;k++) {
				int r=info[0]+dr[k],c=info[1]+dc[k];
				if(0<=r&&r<picture.length&&0<=c&&c<picture[0].length&&picture[r][c]==target) {
					picture[r][c]=0;
					queue.add(new int[] {r,c});
				}
			}
		}
		
		return count;
	}
}