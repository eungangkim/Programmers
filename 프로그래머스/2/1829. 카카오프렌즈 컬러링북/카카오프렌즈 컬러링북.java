class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(picture[i][j]>0) {
        			numberOfArea++;
        			maxSizeOfOneArea=Math.max(maxSizeOfOneArea,getArea(i,j,picture,picture[i][j]));
        		}
        	}
        }
        return new int[] {numberOfArea,maxSizeOfOneArea};
    }
	public int getArea(int i,int j,int [][]picture,int color) {
		int cnt=1;
		int dr[]= {-1,0,1,0};
		int dc[]= {0,1,0,-1};
		picture[i][j]=0;
		for(int x=0;x<4;x++) {
			int row=i+dr[x];
			int col=j+dc[x];
			if(0<=row&&row<picture.length&&0<=col&&col<picture[0].length&&picture[row][col]==color) {
				cnt+=getArea(row,col,picture,color);
			}
		}
		return cnt;
	}
}