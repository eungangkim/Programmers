class Solution {
    public long solution(int n) {
		int a=1;
		int b=2;
		int c=0;
		if(n<=2)return n;
		for(int i=3;i<=n;i++) {
			c=(a+b)%1234567;
			a=b;
			b=c;
		}
		return c;
	}

}