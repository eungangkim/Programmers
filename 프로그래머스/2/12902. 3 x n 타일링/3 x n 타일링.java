class Solution {
    public int solution(int n) {
		long []dp=new long[n/2];
		if(n==2)return 3;
		else if(n==4)return 11;
		dp[0]=3;
		dp[1]=11;
		for(int i=2;i<n/2;i++) {
			for(int j=0;j<i-1;j++) {
				dp[i]=(dp[i]+(dp[j]*2)%1000000007)%1000000007;
			}
			dp[i]=(dp[i]+(dp[i-1]*3)%1000000007+2)%1000000007;
		}
		return (int)dp[n/2-1];
	}
}

