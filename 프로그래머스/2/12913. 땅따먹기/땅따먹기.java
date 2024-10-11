class Solution {
    int solution(int[][] land) {
        int [][]points=new int[land.length][4];
        int firstMax=0,secondMax=0,idx=-1;
        int nextFirMax=0,nextSecMax=0,nextIdx=-1;
        for(int i=0;i<land.length;i++) {
        	nextFirMax=0;
        	nextSecMax=0;
        	for(int j=0;j<4;j++) {
        		if(idx==j) {
            		points[i][j]=secondMax+land[i][j];
        		}
        		else {
            		points[i][j]=firstMax+land[i][j];
        		}
                //System.out.print(points[i][j]+" ");
        		if(points[i][j]>=nextFirMax) {
        			if(nextFirMax!=0)nextSecMax=nextFirMax;
        			nextFirMax=points[i][j];
        			nextIdx=j;
        		}
        		if(nextSecMax<points[i][j]&&points[i][j]<nextFirMax) {
        			nextSecMax=points[i][j];
        		}
        	}
            //System.out.println();
        	firstMax=nextFirMax;
        	secondMax=nextSecMax;
        	idx=nextIdx;
        }
        
        return firstMax;
    }
}