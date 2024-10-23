import java.util.ArrayList;
import java.util.ArrayDeque;
class Solution {
    public int[] solution(String[] maps) {
		int answer[]=new int[]{-1};
		ArrayList<Integer> islands=new ArrayList<>();
		boolean [][]visited=new boolean[maps.length][maps[0].length()];

		for(int i=0;i<maps.length;i++) {
			for(int j=0;j<maps[0].length();j++) {
				char c=maps[i].charAt(j);
				int island=0;
				if('1'<=c&&c<='9'&&!visited[i][j]) {
					visited[i][j]=true;
					island=getIsland(maps,visited,i,j);
					islands.add(island);
				}
			}
		}
		islands.sort(null);
		answer=islands.size()==0?answer:new int[islands.size()];
		for(int i=0;i<answer.length&&islands.size()>0;i++) {
			answer[i]=islands.get(i);
		}
		return answer;
	}
	public int getIsland(String[] maps,boolean [][]visited,int i,int j) {
		ArrayDeque<int []> queue=new ArrayDeque<>();
		queue.add(new int[] {i,j});
		int dr[]= {0,1,0,-1};
		int dc[]= {1,0,-1,0};
		int sum=0;
		while(!queue.isEmpty()) {
			int pos[]=queue.poll();
			sum+=maps[pos[0]].charAt(pos[1])-'0';
			for(int k=0;k<4;k++) {
				int r=pos[0]+dr[k];
				int c=pos[1]+dc[k];
				if(0<=r&&r<maps.length&&0<=c&&c<maps[0].length()&&maps[r].charAt(c)!='X'&&!visited[r][c]) {
					queue.add(new int[]{r,c});
					visited[r][c]=true;
				}
			}
		}
		return sum;
	}
}