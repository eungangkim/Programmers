class Solution {
    int solution(int[][] land) {
		int firMaxIdx=0,secMaxIdx=0;
		for(int i=0;i<land.length;i++) {
            firMaxIdx=0;
            secMaxIdx=1;
			for(int j=1;j<4;j++) {
				if(land[i][firMaxIdx]<=land[i][j]) {
					secMaxIdx=firMaxIdx;
					firMaxIdx=j;
				}
				else if(land[i][secMaxIdx]<=land[i][j]){
					secMaxIdx=j;
				}
			}
			if(i==land.length-1)break;
			for(int j=0;j<4;j++) {
				if(j==firMaxIdx)land[i+1][j]+=land[i][secMaxIdx];
				else land[i+1][j]+=land[i][firMaxIdx];
			}
		}
		return land[land.length-1][firMaxIdx];
	}
}