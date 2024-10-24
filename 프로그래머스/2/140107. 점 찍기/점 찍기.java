class Solution {
    public long solution(int k, int d) {
		long answer=0;
		for(int a=0;a<=d;a+=k) {
			int r=(int)Math.sqrt(Math.abs((long)a*a-(long)d*d));
			answer+=r/k+1;
		}
		return answer;
	}
}