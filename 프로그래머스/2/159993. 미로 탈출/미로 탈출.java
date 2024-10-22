import java.util.ArrayDeque;

class Solution {
    public int solution(String[] maps) {
		ArrayDeque<int []> queue=new ArrayDeque<>();
		boolean[][]visited=new boolean[maps.length][maps[0].length()];
		char map[][]=new char[maps.length][maps[0].length()];
		int start[]=null,lever[]=null,finish[]=null;
		int dr[]= {0,1,0,-1};
		int dc[]= {1,0,-1,0};
		boolean doorOpen=false;
		
		for(int i=0;i<maps.length;i++) {
			for(int j=0;j<maps[0].length();j++) {
				char c=maps[i].charAt(j);
				if(c=='S') {
					start=new int[] {i,j,0};
				}
				else if(c=='E') {
					finish=new int[] {i,j};
				}
				else if(c=='L') {
					lever=new int[] {i,j};
				}
				else if(c=='X') {
					map[i][j]=1;
				}
			}
		}
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int pos[]=queue.poll();
			if(doorOpen&&pos[0]==finish[0]&&pos[1]==finish[1])
				return pos[2];
			if(pos[0]==lever[0]&&pos[1]==lever[1]) {
				doorOpen=true;
				queue.clear();
				visited=new boolean[maps.length][maps[0].length()];
				visited[pos[0]][pos[1]]=true;
			}
			for(int i=0;i<4;i++) {
				int r=pos[0]+dr[i];
				int c=pos[1]+dc[i];
				if(r>=0&&r<map.length&&c>=0&&c<map[0].length&&!visited[r][c]&&map[r][c]!=1) {
					queue.add(new int[] {r,c,pos[2]+1});
					visited[r][c]=true;
				}
			}
		}
		return -1;
	}
}