class Solution {
    int answer[];
	int [][]arr;
	public int[] solution(int[][] arr) {
        answer = new int[2];
        this.arr=arr;
        bfs(0,0,arr.length);
        return answer;
    }
	public void bfs(int row,int col,int length) {
		for(int i=row;i<row+length;i++) {
			for(int j=col;j<col+length;j++) {
				if(arr[row][col]!=arr[i][j]) {
					bfs(row,col,length/2);
					bfs(row,col+length/2,length/2);
					bfs(row+length/2,col,length/2);
					bfs(row+length/2,col+length/2,length/2);
					return;
				}
			}
		}
		answer[arr[row][col]]++;
	}
}