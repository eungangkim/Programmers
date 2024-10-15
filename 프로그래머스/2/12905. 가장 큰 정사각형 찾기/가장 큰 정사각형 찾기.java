class Solution{
   public int solution(int [][]board){
		int max=0;
		int n = board.length;
        int m = board[0].length;

        for (int d = 0; d < n + m - 1; d++) {
            // 대각선의 시작점 계산
            int rowStart = d < m ? 0 : d - m + 1;
            int colStart = d < m ? d : m - 1;

            // 대각선으로 요소 출력
            for (int i = rowStart, j = colStart; i < n && j >= 0; i++, j--) {
            	if(board[i][j]!=0) {
    				if(0<=i-1&&0<=j-1) {
    					board[i][j]=Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1])+1;
    				}
                    max=Math.max(max, board[i][j]);
    			}
            }
        }
		return max*max;
	}
}
