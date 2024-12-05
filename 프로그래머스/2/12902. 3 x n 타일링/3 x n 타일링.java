class Solution {
    public int solution(int n) {
		long sum=0;
		long a=3,b=3;
		for(int i=1;i<n/2;i++){
			b=((sum*2)%1000000007+(a*3)%1000000007+2)%1000000007;
			sum+=a;
            a=b;
		}
		return (int)b;
	}
}
