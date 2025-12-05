import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        HashMap<Character,ArrayDeque<int[]>> LUT=new HashMap<>();
        boolean visited[][]=new boolean[storage.length][storage[0].length()];
        boolean outsider[][]=new boolean[storage.length][storage[0].length()];
        initLUT(LUT,storage);
        
        for(int i=0;i<requests.length;i++) {
        	char request=requests[i].charAt(0);
        	ArrayDeque<int[]> queue=LUT.get(request);
        	ArrayDeque<int[]> outs=new ArrayDeque<>();
            if(queue==null)continue;
        	if(requests[i].length()==1) {
        		ArrayDeque<int[]> rest=new ArrayDeque<>();
        		while(!queue.isEmpty()) {
        			int pos[] = queue.pop();
                    
        			if(isAccessible(pos,outsider)) {
        				outs.add(pos);
        			}
        			else {
        				rest.add(pos);
        			}
        		}
        		LUT.put(request, rest);
        	}
            
        	else {
        		while(!queue.isEmpty()) {
        			int pos[] = queue.pop();
                    outs.add(pos);
        		}
        	}
        	while(!outs.isEmpty()) {
        		int pos[]=outs.pop();
                visited[pos[0]][pos[1]]=true;
        	    if(requests[i].length()==1||isAccessible(pos,outsider)) {
                    outsider[pos[0]][pos[1]]=true;
                    updateOutsider(pos,outsider,visited);
                }
        	}
        }
        for(ArrayDeque<int[]> queue:LUT.values()) {
        	answer+=queue.size();
        }
        return answer;
    }
	private void initLUT(HashMap<Character,ArrayDeque<int[]>> LUT,String[] storage) {
		for(int i=0;i<storage.length;i++) {
			String s=storage[i];
			for(int j=0;j<s.length();j++) {
				char c=s.charAt(j);
				ArrayDeque<int[]> queue=LUT.get(c);
				if(queue==null) {
					queue=new ArrayDeque<>();
					LUT.put(c, queue);
				}
				queue.add(new int[] {i,j});
			}
		}
	}
	private boolean isAccessible(int[] pos,boolean[][] outsider) {
		int row[]= {-1,0,1,0};
		int col[]= {0,1,0,-1};
		
		for(int i=0;i<4;i++) {
			int r=pos[0]+row[i];
			int c=pos[1]+col[i];
			if(r<0||r>=outsider.length||c<0||c>=outsider[0].length||outsider[r][c]==true) {
				return true;
			}
		}
		return false;
	}
	private void updateOutsider(int[] pos,boolean[][] outsider,boolean[][] visited) {
		int row[]= {-1,0,1,0};
		int col[]= {0,1,0,-1};
		
		for(int i=0;i<4;i++) {
			int r=pos[0]+row[i];
			int c=pos[1]+col[i];
			if(r>=0&&r<visited.length&&c>=0&&c<visited[0].length&&visited[r][c]&&!outsider[r][c]) {
				outsider[r][c]=true;
				updateOutsider(new int[] {r,c},outsider,visited);
			}
		}
	}
}