class Solution {
    public int solution(int n, int[] tops) {
		int dp[]=new int[2*n+1];
		dp[0]=1;
        if(tops[0]==1)
            dp[1]=3;
        else
		    dp[1]=2;
		for(int i=2;i<dp.length;i++) {
			if(i%2==1&&tops[i/2]==1) {
				dp[i]=(dp[i-1]*2+dp[i-2])%10007;
			}
			else {
				dp[i]=(dp[i-1]+dp[i-2])%10007;
			}
		}
		return dp[dp.length-1]%10007;
	}
}