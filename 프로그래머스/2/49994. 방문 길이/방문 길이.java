import java.util.HashMap;

class Solution {
    public int solution(String dirs) {
		HashMap<Character,int[]> map=new HashMap<>();
		int countOfFirstWay=0;
		boolean visited [][][]=new boolean[11][11][4];
		int r=5;
		int c=5;
		
		map.put('U', new int[]{-1,0,0});
		map.put('D', new int[]{1,0,2});
		map.put('R', new int[]{0,1,1});
		map.put('L', new int[]{0,-1,3});
		
		for(int i=0;i<dirs.length();i++) {
			int ds[]=map.get(dirs.charAt(i));
			if(inRange(r+ds[0])&&inRange(c+ds[1])){
                if(!visited[r][c][ds[2]]) {
                    visited[r][c][ds[2]]=true;
                    visited[r+ds[0]][c+ds[1]][(ds[2]+2)%4]=true;
                    countOfFirstWay++;
                }
				r+=ds[0];
				c+=ds[1];
			}
		}
		return countOfFirstWay;
	}
	public boolean inRange(int k) {
		if(0<=k&&k<11)return true;
		return false;
	}
}