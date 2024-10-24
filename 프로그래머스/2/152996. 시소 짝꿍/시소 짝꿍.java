class Solution {
    public long solution(int[] weights) {
		long []weight=new long[901];
		long answer=0;
		for(int w:weights) {
			weight[w-100]++;
		}
		for(int i=0;i<weight.length;i++) {
			if(weight[i]==0)continue;
			int w=i+100;
			if(weight[i]>1) {
				answer+=weight[i]*(weight[i]-1)/2;
			}
			if(w%2==0&&w*3/2-100<weight.length&&weight[w*3/2-100]>0) {
				answer+=weight[i]*weight[w*3/2-100];
			}
			if(w*2-100<weight.length&&weight[w*2-100]>0) {
				answer+=weight[i]*weight[w*2-100];
			}
			if(w%3==0&&w*4/3-100<weight.length&&weight[w*4/3-100]>0) {
				answer+=weight[i]*weight[w*4/3-100];
			}
		}
		return answer;
	}
}