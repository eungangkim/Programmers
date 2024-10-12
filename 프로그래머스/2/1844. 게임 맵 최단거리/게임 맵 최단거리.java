import java.util.ArrayDeque;
class Solution {
    public int solution(int[][] maps) {
        ArrayDeque<int[]> queue=new ArrayDeque<>();
        boolean [][]visited=new boolean[maps.length][maps[0].length];
        
		int [] dr= {-1,0,1,0};
		int [] dc= {0,1,0,-1};
		
		queue.add(new int[] {maps.length-1,maps[0].length-1,1});
		while(!queue.isEmpty()) {
			int [] loc=queue.poll();
            //System.out.println(loc[0]+" "+loc[1]);
			if(loc[0]==0&&loc[1]==0)return loc[2];
			for(int x=0;x<4;x++) {
				if(0<=loc[0]+dr[x]&&loc[0]+dr[x]<maps.length&&0<=loc[1]+dc[x]&&loc[1]+dc[x]<maps[0].length&&maps[loc[0]+dr[x]][loc[1]+dc[x]]==1&&!visited[loc[0]+dr[x]][loc[1]+dc[x]]) {
					queue.add(new int[] {loc[0]+dr[x],loc[1]+dc[x],loc[2]+1});
                    visited[loc[0]+dr[x]][loc[1]+dc[x]]=true;
				}
			}
		}
        return -1;
    }
}