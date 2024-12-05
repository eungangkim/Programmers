class Solution {
  public int[] solution(long begin, long end) {
		int answer[]=new int[(int)(end-begin)+1];
		int start=(int) begin;
		if(begin==1) {
			start++;
		}
		for(int i=start;i<=end;i++) {
			int sqrt=(int) Math.sqrt(i);
			for(int k=2;k<=sqrt;k++) {
				if(i%k==0) {
					answer[(int) (i-begin)]=k;
					if(i/k<=10000000) {
						answer[(int) (i-begin)]=i/k;
						break;
					}
				}
			}
			if(answer[(int) (i-begin)]==0)answer[(int) (i-begin)]=1;
		}
		return answer;
	}
}