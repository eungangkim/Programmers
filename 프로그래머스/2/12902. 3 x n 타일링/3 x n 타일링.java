class Solution {
    public int solution(int n) {
		long []dp=new long[n/2];
		if(n==2)return 3;
		dp[0]=3;
        long sum=0;
		for(int i=1;i<n/2;i++) {
			dp[i]=(dp[i]+(sum*2)%1000000007)%1000000007;
			dp[i]=(dp[i]+(dp[i-1]*3)%1000000007+2)%1000000007;
            sum+=dp[i-1];
		}
		return (int)dp[n/2-1];
	}
}



