class Solution{
   public int solution(int [][]board){
		int i=0,j=0;
		int nexti=0,nextj=1;
		int max=0;
		while(i<board.length&&j<board[0].length) {
			if(board[i][j]!=0) {
				if(0<=i-1&&0<=j-1) {
					int min=Math.min(board[i-1][j],board[i][j-1]);
					if(0<=i-min&&0<=j-min&&board[i-min][j-min]!=0)board[i][j]=min+1;
                    else board[i][j]=min;
				}
                max=Math.max(max, board[i][j]);
			}
            if(j==0||i==board.length-1) {
				i=nexti;
				j=nextj;
				
				if(nextj<board[0].length-1) {
					nextj++;
				}
				else {
					nexti++;
				}
				continue;
			}
			i++;
			j--;
		}
		return max*max;
	}
}
