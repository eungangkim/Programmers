import java.util.ArrayDeque;
class Solution {
    public int solution(String[] board) {
    	ArrayDeque<int[]>queue=new ArrayDeque<>();// bfs방식 사용
    	boolean [][]visited=new boolean[board.length][board[0].length()];//방문 여부
    	int [][]map=new int[board.length][board[0].length()]; //1=벽 0=길
    	int start[]=null;//출발잠 좌표
    	int finish[]=null;//도착점 좌표
    	int dr[]= {0,1,0,-1};
    	int dc[]= {1,0,-1,0};
    	
    	for(int i=0;i<board.length;i++) {
    		for(int j=0;j<board[0].length();j++) {
    			char c=board[i].charAt(j);
    			if(c=='R') {
    				start=new int[] {i,j,0};
    			}
    			else if(c=='G') {
    				finish=new int[] {i,j};
    			}
    			else if(c=='D') {
    				map[i][j]=1;
    			}
    		}
    	}
    	
    	queue.add(start);
    	visited[start[0]][start[1]]=true;
    	while(!queue.isEmpty()) {
    		int pos[]=queue.poll();
    		if(pos[0]==finish[0]&&pos[1]==finish[1])return pos[2];
    		for(int i=0;i<4;i++) {
    			int r=pos[0];
    			int c=pos[1];
    			while(r+dr[i]>=0&&r+dr[i]<board.length&&c+dc[i]>=0&&c+dc[i]<board[0].length()&&map[r+dr[i]][c+dc[i]]==0) {
    				r+=dr[i];
    				c+=dc[i];
    			}
    			if((r!=pos[0]||c!=pos[1])&&!visited[r][c]) {
    				queue.add(new int[] {r,c,pos[2]+1});
    				visited[r][c]=true;
    			}
    		}
    	}
    	return -1;
    }
}