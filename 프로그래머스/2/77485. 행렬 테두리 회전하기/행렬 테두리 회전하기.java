class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int map[][]=new int[rows][columns];
		int []answer=new int[queries.length];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				map[i][j]=i*columns+j+1;
			}
		}
		
		for(int i=0;i<queries.length;i++) {
			answer[i]=rotate(queries[i],map);
		}
		return answer;
	}
	public int rotate(int []querie,int [][]map) {
		int min=Integer.MAX_VALUE;
		int cnt=(querie[2]-querie[0])*2+(querie[3]-querie[1])*2;
		int temp=map[querie[0]-1][querie[1]-1],i=querie[0],j=querie[1],k=0;
		int []dr= {1,0,-1,0};
		int []dc= {0,1,0,-1};
		
		while(cnt>1) {
			map[i-1][j-1]=map[i+dr[k]-1][j+dc[k]-1];
			min=Math.min(min,map[i-1][j-1]);
			i+=dr[k];
			j+=dc[k];
			if(i==querie[0]&&(j==querie[1]||j==querie[3])||(i==querie[2]&&(j==querie[1]||j==querie[3])))
				k++;
			cnt--;
		}
        
		map[i-1][j-1]=temp;
		min=Math.min(min,map[i-1][j-1]);
        
		return min;
	}
}