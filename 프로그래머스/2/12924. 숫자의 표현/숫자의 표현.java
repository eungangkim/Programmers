class Solution {
    public int solution(int n) {
		int start=1,end=1,sum=0,count=0;
		
		while(start<=n||end<=n) {
			if(sum<n) {
				sum+=end++;
			}
			else if(sum>n) {
				sum-=start++;
			}
			else if(sum==n){
				sum-=start++;
				count++;
			}
		}
		return count;
	}
}