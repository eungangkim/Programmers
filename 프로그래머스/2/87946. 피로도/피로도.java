import java.util.ArrayList;

class Solution {
    public int solution(int k, int[][] dungeons) {
		ArrayList<int[]> dungeonList=new ArrayList<>();
		for(int i=0;i<dungeons.length;i++) {
			dungeonList.add(dungeons[i]);
		}
		return dungeons.length-bfs(k,dungeonList);
	}
	public int bfs(int fatigue,ArrayList<int []> dungeonList) {
		int min=Integer.MAX_VALUE;
		boolean flag=false;
		for(int i=0;i<dungeonList.size();i++) {
			int []dungeon=dungeonList.remove(i);
			if(dungeon[0]<=fatigue) {
				flag=true;
				min=Math.min(min, bfs(fatigue-dungeon[1],dungeonList));
			}
			dungeonList.add(i,dungeon);
		}
		if(!flag) {
			return dungeonList.size();
		}
		return min;
	}
}