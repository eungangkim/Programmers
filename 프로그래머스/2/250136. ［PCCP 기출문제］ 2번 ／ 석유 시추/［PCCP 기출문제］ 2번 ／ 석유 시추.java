import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
		public int solution(int[][] land) {
		int maxOil=0;
		int [][] landNum=new int[land.length][land[0].length];	
		ArrayList<Integer> areas=new ArrayList<>();
		int nextLandNum=1;
		for(int i=0;i<land.length;i++) {
			for(int j=0;j<land[0].length;j++) {
				if(land[i][j]==1&&landNum[i][j]==0) {
					areas.add(getArea(land,landNum,i,j,nextLandNum));
					nextLandNum++;
				}
			}
		}
		
		for(int k=0;k<land[0].length;k++) {
			maxOil=Math.max(maxOil, getTotalOil(landNum,areas,k));
		}
		
		return maxOil;
	}
	private int getArea(int [][]land,int [][] landNum,int row,int col,int nextLandNum) {
		ArrayDeque<int[]> queue=new ArrayDeque<>();
		int count=0;
		int r[]= {-1,0,1,0};
		int c[]= {0,1,0,-1};
		landNum[row][col]=nextLandNum;
		queue.add(new int[] {row,col});
		while(!queue.isEmpty()) {
			count++;
			int location[]=queue.pop();
			for(int i=0;i<4;i++) {
				int nextRow=location[0]+r[i];
				int nextCol=location[1]+c[i];
				if(checkRange(nextRow,nextCol,land.length,land[0].length)&&land[nextRow][nextCol]==1&&landNum[nextRow][nextCol]==0) {
					queue.add(new int[] {nextRow,nextCol});
					landNum[nextRow][nextCol]=nextLandNum;
				}
			}
		}
		return count;
	}
	private boolean checkRange(int row,int col,int limitR,int limitC) {
		if(row>=0&&row<limitR&&col>=0&&col<limitC)
			return true;
		return false;
	}
	private int getTotalOil(int [][]landNum,ArrayList<Integer> areas,int col) {
		int totalOil=0;
		boolean[] visited=new boolean[areas.size()];
		for(int i=0;i<landNum.length;i++) {
			int num=landNum[i][col];
			if(num!=0&&!visited[num-1]) {
				totalOil+=areas.get(num-1);
				visited[num-1]=true;
			}
		}
		return totalOil;
	}
}