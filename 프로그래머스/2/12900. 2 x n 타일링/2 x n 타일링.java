class Solution {
    public int solution(int n) {
		int a=1,b=2,c=0;
		for(int i=2;i<n;i++) {
			c=(a+b)%1000000007;
			a=b;
			b=c;
		}
		return n<3?n:c;
	}
}