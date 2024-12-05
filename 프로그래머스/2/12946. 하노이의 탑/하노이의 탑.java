import java.util.ArrayDeque;

class Solution {
    public int[][] solution(int n) {		
		int time=(int) (Math.pow(2, n)-1);
		int [][] record=new int[time][2];
        int [][] move= {{1,2},{0,2},{0,1}};
        int from=0;
        ArrayDeque<Integer>[] hanoi=initHanoi(n);
        
		for(int i=0;i<time;i++) {
			int size=hanoi[from].size(),to=move[from][size%2];
			
			if(size!=0&&(hanoi[to].isEmpty()||hanoi[from].peekLast()<hanoi[to].peekLast())) {
				hanoi[to].add(hanoi[from].pollLast());
				record[i][0]=from+1;
				record[i][1]=to+1;
			}
			else {
				from=to;
                i--;
			}
		}
		return record;
	}
    public ArrayDeque<Integer>[] initHanoi(int n){
    	ArrayDeque<Integer>[] hanoi=new ArrayDeque[3];
        hanoi[0]=new ArrayDeque<>();
        hanoi[1]=new ArrayDeque<>();
        hanoi[2]=new ArrayDeque<>();
        
        for(int i=n;i>=1;i--) {
        	hanoi[0].add(i);
        }
        return hanoi;
    }
}