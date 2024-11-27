class Solution {
    public int solution(int n) {
		int [][]board=new int[n][n];
		return dfs(0,board);
	}
	public int dfs(int k,int [][]board) {
		int cnt=0;
		int dc[]= {-1,0,1};
		if(k==board.length) {
			return 1;
		}
		for(int i=0;i<board.length;i++) {
			boolean flag=true;
			for(int j=0;j<3&&flag;j++) {
				int r=k,c=i;
				while(0<=r&&0<=c&&c<board.length&&board[r][c]==0) {
					r-=1;
					c+=dc[j];
				}
				if(0<=r&&0<=c&&c<board.length)flag=false;
			}
			if(flag) {
				board[k][i]=1;
				cnt+=dfs(k+1,board);
                board[k][i]=0;
			}
		}
		return cnt;
	}
    public void show(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}