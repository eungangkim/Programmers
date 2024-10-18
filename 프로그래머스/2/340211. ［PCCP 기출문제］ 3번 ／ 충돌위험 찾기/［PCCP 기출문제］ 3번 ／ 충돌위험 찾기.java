
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
		ArrayDeque<Robot> queue=new ArrayDeque<>(),next;
		int maxLength=0;
		int collision=0;
		for(int i=0;i<points.length;i++) {
			maxLength=Math.max(maxLength, points[i][0]);
			maxLength=Math.max(maxLength, points[i][1]);

		}
		for(int i=0;i<routes.length;i++) {
			queue.add(new Robot(points,routes[i]));
		}
		
		while(!queue.isEmpty()) {
			next=new ArrayDeque<>();

			int [][] visited=new int[maxLength+1][maxLength+1];
			while(!queue.isEmpty()) {
				Robot robot=queue.poll();
				if(visited[robot.getR()][robot.getC()]==1) {
					collision++;
				}
				visited[robot.getR()][robot.getC()]++;
				if(robot.move(points)) {
					next.add(robot);
				}
			}
			queue=next;
		}
		return collision;
	}
	class Robot{
		int routes[];
		int targetRouteIdx;
		int points[];
		public Robot(int [][]p,int r[]) {
            routes=new int[r.length];
			for(int i=0;i<r.length;i++) {
				routes[i]=r[i];
			}
			targetRouteIdx=1;
			points=new int[2];
			points[0]=p[r[0]-1][0];
			points[1]=p[r[0]-1][1];
		}
		public int getR() {
			return points[0];
		}
		public int getC() {
			return points[1];
		}
		public boolean move(int [][]p) {
			if(targetRouteIdx==routes.length)return false;
			if(p[routes[targetRouteIdx]-1][0]==points[0]) 
				if(p[routes[targetRouteIdx]-1][1]-points[1]<0) 
					points[1]--;
				else
					points[1]++;
			else 
				if(p[routes[targetRouteIdx]-1][0]-points[0]<0) 
					points[0]--;
				else
					points[0]++;
			
			if(p[routes[targetRouteIdx]-1][0]==points[0]&&p[routes[targetRouteIdx]-1][1]==points[1]) {
				targetRouteIdx++;
			}
			return true;
		}
	}
}