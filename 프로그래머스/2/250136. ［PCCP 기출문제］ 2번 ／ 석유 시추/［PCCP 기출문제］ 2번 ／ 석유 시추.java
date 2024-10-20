import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;
class Solution {
	public int solution(int[][] land) {
		int answer=0;
		int k=2;
		HashMap<Integer,Integer> oilWeights=new HashMap<>();
		
		for(int i=0;i<land.length;i++) {
			for(int j=0;j<land[0].length;j++) {
				if(land[i][j]==1) {
					oilWeights.put(k, getWeight(k,land,i,j));
					k++;
				}
			}
		}
		for(int j=0;j<land[0].length;j++) {
			int weight=0;
			HashSet<Integer> set=new HashSet<>();
			for(int i=0;i<land.length;i++) {
				if(land[i][j]!=0&&set.add(land[i][j])) {
					weight+=oilWeights.get(land[i][j]);
				}
			}
			answer=Math.max(answer, weight);
        }
		return answer;
	}
	public int getWeight(int k,int [][]land,int i,int j) {
		int weight=1;
		ArrayDeque<int []> queue=new ArrayDeque<>();
		queue.add(new int [] {i,j});
		land[i][j]=k;
		while(!queue.isEmpty()) {
			int point[]=queue.poll();
			if(point[0]-1>=0&&land[point[0]-1][point[1]]==1) {
                land[point[0]-1][point[1]]=k;
    			weight++;
				queue.add(new int[] {point[0]-1,point[1]});
			}
			if(point[0]+1<land.length&&land[point[0]+1][point[1]]==1) {
                land[point[0]+1][point[1]]=k;
    			weight++;
				queue.add(new int[] {point[0]+1,point[1]});	
			}
			if(point[1]-1>=0&&land[point[0]][point[1]-1]==1) {
                land[point[0]][point[1]-1]=k;
    			weight++;
				queue.add(new int[] {point[0],point[1]-1});	
			}
			if(point[1]+1<land[0].length&&land[point[0]][point[1]+1]==1) {
                land[point[0]][point[1]+1]=k;
    			weight++;
				queue.add(new int[] {point[0],point[1]+1});	
			}
		}
		return weight;
	}
}