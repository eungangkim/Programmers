import java.util.ArrayDeque;
class Solution {
    public int solution(int m, int n, String[] board) {
		ArrayDeque<int[]> delete=new ArrayDeque<>();
		int nOfDeletedBlock=0;
		char [][]charBoard=initBoard(board);
		
		findDelete(delete,charBoard);
		while(delete.size()>0) {
			nOfDeletedBlock+=delete(delete,charBoard);
			restructure(charBoard);
            findDelete(delete,charBoard);
		}
		return nOfDeletedBlock;
	}
	public char[][] initBoard(String[] board){
		char [][]charBoard=new char[board.length][];
		for(int i=0;i<board.length;i++) {
			charBoard[i]=board[i].toCharArray();
		}
		return charBoard;
	}
	public void findDelete(ArrayDeque<int[]> delete,char[][] board) {
		for(int i=0;i<board.length-1;i++) {
			for(int j=0;j<board[0].length-1;j++) {
				char c=board[i][j];
				if(c=='-')continue;
				if(c==board[i][j+1]&&c==board[i+1][j]&&c==board[i+1][j+1])
					delete.add(new int[] {i,j});
			}
		}
	}
	public int delete(ArrayDeque<int[]> delete,char[][] board) {
		int count=0;
		int []dr= {0,0,1,1};
		int []dc= {0,1,0,1};
		while(!delete.isEmpty()) {
			int point[]=delete.poll();
			for(int i=0;i<4;i++) {
				if(board[point[0]+dr[i]][point[1]+dc[i]]!='-') {
					count++;
					board[point[0]+dr[i]][point[1]+dc[i]]='-';
				}
			}
		}
		return count;
	}
	public void restructure(char[][] board) {
		for(int j=0;j<board[0].length;j++) {
			for(int i=board.length-1;i>0;i--) {
				if(board[i][j]=='-') {
					int bottom=i;
					while(i>0) {
						while(i>0&&board[i][j]=='-') {
							i--;
						}
						board[bottom--][j]=board[i][j];
						board[i][j]='-';
					}
					break;
				}
			}
		}
	}
    public void show(char[][] board){
        for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j]+" ");
			}
            System.out.println();
		}
    }
}