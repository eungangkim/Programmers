class Solution {
    public int solution(int n) {
        int [][] board=new int[n][n];  
        return dfs(0,board);
    }
	public int dfs(int h,int [][] board) {
		if(h==board.length) {
			return 1;
		}
		int cnt=0;
		for(int i=0;i<board.length;i++) {
			if(board[h][i]==0) {
				int clone[][]=attackMark(h,i,board);
				cnt+=dfs(h+1,clone);
				attackDelete(h,i,board);
			}
		}
		return cnt;
	}
	public int[][] attackMark(int r,int c,int board[][]){
		int []dr= {-1,-1, 0, 1,1, 1, 0,-1};
		int []dc= {0 , 1, 1, 1,0,-1,-1,-1};
		int ds=0;
		while(ds<8) {
			int tr=r,tc=c;
			while(0<=tr&&tr<board.length&&0<=tc&&tc<board.length) {
				board[tr][tc]+=1;
				tr+=dr[ds];
				tc+=dc[ds];
			}
			ds++;
		}
		return board.clone();
	}
	public void attackDelete(int r,int c,int[][]board) {
		int []dr= {-1,-1, 0, 1,1, 1, 0,-1};
		int []dc= {0 , 1, 1, 1,0,-1,-1,-1};
		int ds=0;
		while(ds<8) {
			int tr=r,tc=c;
			while(0<=tr&&tr<board.length&&0<=tc&&tc<board.length) {
				board[tr][tc]-=1;
				tr+=dr[ds];
				tc+=dc[ds];
			}
			ds++;
		}
	}
}