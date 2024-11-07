class Solution {
    public int[] solution(int n) {
		int [][]map = new int[n][n];
		int []answer=new int[((n+1)*n)/2];
		int cnt=1,end=((n+1)*n)/2,k=0,i=0,j=0;
		int [][] delta= {{1,0},{0,1},{-1,-1}};
		while(cnt<=end) {
			int nexti=i+delta[k][0],nextj=j+delta[k][1];
			map[i][j]=cnt++;
			if(nexti<0||n<=nexti||nextj<0||n<=nextj||map[nexti][nextj]!=0) {
				k=(k+1)%3;
			}
			i+=delta[k][0];
			j+=delta[k][1];
		}
		
		for(i=0;i<n;i++) {
			int start=((i+1)*i)/2;
			for(j=0;j<i+1;j++) {
				answer[start+j]=map[i][j];
			}
		}
		return answer;
	}
}