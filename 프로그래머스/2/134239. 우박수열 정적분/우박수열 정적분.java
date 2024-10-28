import java.util.ArrayList;

class Solution {
    public double[] solution(int k, int[][] ranges) {
		ArrayList<Double> size=new ArrayList<>();
		double answer[]=new double[ranges.length];
		
		setList(k,size);
		
		for(int i=0;i<ranges.length;i++) {
			answer[i]=getWidth(ranges[i],size);
		}
		
		return answer;
	}
	public double getWidth(int []range,ArrayList<Double> size) {
		if(range[0]>size.size()+range[1]) {
			return -1;
		}
		double width=0;
		
		for(int i=range[0];i<size.size()+range[1];i++) {
			width+=size.get(i);
		}
		
		return width;
	}
	public void setList(double k,ArrayList<Double> size) {
		if(k==1) {
			return ;
		}
		if(k%2==0) {
			size.add((k+k/2)/2);
			k/=2;
		}
		else if(k%2==1) {
			size.add((k+k*3+1)/2);
			k=k*3+1;
		}
		setList(k,size);
	}
}