
class Solution {
    public int solution(String[] board) {
		int num_O=0;
        int num_X=0;
        int num_bingo_O=0;
        int num_bingo_X=0;
        for(int i=0;i<3;i++) {
        	int row_O=0,col_O=0;
        	int row_X=0,col_X=0;
        	
        	for(int j=0;j<3;j++) {
        		char rc=board[i].charAt(j);
        		char cc=board[j].charAt(i);
        		if(rc=='O') {
        			row_O++;
        			num_O++;
        		}
        		else if(rc=='X') {
        			row_X++;
        			num_X++;
        		}
        		if(cc=='O') {
        			col_O++;
        		}
        		else if(cc=='X') {
        			col_X++;
        		}
        	}
        	if(row_O==3)num_bingo_O++;
        	if(col_O==3)num_bingo_O++;
        	if(row_X==3)num_bingo_X++;
        	if(col_X==3)num_bingo_X++;
        }
        
        int diagonal_O1=0,diagonal_O2=0,diagonal_X1=0,diagonal_X2=0;
        for(int i=0;i<3;i++) {
        	char c1=board[i].charAt(i);
        	char c2=board[i].charAt(2-i);
        	if(c1=='O') 
        		diagonal_O1++;
        	if(c2=='O')
        		diagonal_O2++;
        	if(c1=='X') {
        		diagonal_X1++;
        	}
        	if(c2=='X')
        		diagonal_X2++;
        }
        if(diagonal_O1==3)num_bingo_O++;
        if(diagonal_O2==3)num_bingo_O++;
        if(diagonal_X1==3)num_bingo_X++;
        if(diagonal_X2==3)num_bingo_X++;
        
        if(num_bingo_O+num_bingo_X==0) {
        	if(num_O==num_X||num_O==num_X+1)return 1;
        }
        else if(num_bingo_O+num_bingo_X==1) {
        	if(num_bingo_O==1&&num_O==num_X+1)return 1;
        	else if(num_bingo_X==1&&num_O==num_X)return 1;
        }
        else if(num_bingo_O==2&&num_bingo_X==0) {
        	if(num_O==num_X+1)return 1;
        }
        return 0;
	}
}