
class Solution {
	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int answer[]=new int[balls.length];
		for(int i=0;i<balls.length;i++) {
			int min=Integer.MAX_VALUE;
			min=Math.min(min, getDistance(Math.abs(startX-balls[i][0]),n-startY,n-balls[i][1]));//위
			min=Math.min(min, getDistance(Math.abs(startX-balls[i][0]),startY,balls[i][1]));//아래
			min=Math.min(min, getDistance(Math.abs(startY-balls[i][1]),m-startX,m-balls[i][0]));//오른쪽
			min=Math.min(min, getDistance(Math.abs(startY-balls[i][1]),startX,balls[i][0]));//왼쪽
			answer[i]=min;
		}
		return answer;
	}
	public int getDistance(double width,double height1,double height2) {
		if(width==0) {
			if(height1<height2) {
				return (int)((height1+height2)*(height1+height2));
			}
			return Integer.MAX_VALUE;	
		}
		double width1=(height1*width)/(height1+height2);
		double width2=width-width1;
		double a=height1*height1+width1*width1;
		double b=height2*height2+width2*width2;
		return (int)Math.round((a+b+2*Math.sqrt(a)*Math.sqrt(b)));
	}
}