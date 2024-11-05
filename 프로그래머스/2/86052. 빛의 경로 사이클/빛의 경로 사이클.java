import java.util.ArrayList;
class Solution {
	Node[][] map;
	ArrayList<Integer> answer;
	int []dr= {1,0,-1,0};
	int []dc= {0,1,0,-1};
	public int[] solution(String[] grid) {
		int []ans;
		answer=new ArrayList<>();
		map=new Node[grid.length][grid[0].length()];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				map[i][j]=new Node(grid[i].charAt(j),i,j);
			}
		}
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				map[i][j].getCycle();
			}
		}
		
		ans=new int[answer.size()];
		answer.sort(null);
		for(int i=0;i<ans.length;i++) {
			ans[i]=answer.get(i);
		}
		return ans;
	}
	class Node{
		int [][]nextIdx;
		boolean[] visited; //
		public Node(char s,int i,int j) {
			visited=new boolean[4];
			nextIdx=new int[4][3];
			int start=s=='S'?0:s=='R'?1:3;
			for(int k=start;k<start+4;k++) {
				nextIdx[k-start][0]=i+dr[k%4]<0?map.length-1:(i+dr[k%4])%map.length;
				nextIdx[k-start][1]=j+dc[k%4]<0?map[0].length-1:(j+dc[k%4])%map[0].length;
				nextIdx[k-start][2]=k%4;
			}
		}
		
		public void getCycle() {
			for(int i=0;i<4;i++) {
				if(!visited[i]) {
					visited[i]=true;
					int k=1;
					int []next=nextIdx[i];
					Node node=map[next[0]][next[1]];
					while(!node.visited[next[2]]) {
						node.visited[next[2]]=true;
						k++;
						next=node.nextIdx[next[2]];
						node=map[next[0]][next[1]];
					}
					answer.add(k);
				}
			}
		}
	}
}