import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
		HashSet<Integer> set=new HashSet<>();
		int []dp=new int[elements.length];
		
		for(int k=0;k<elements.length-1;k++) {
			for(int i=0;i<elements.length;i++) {
				dp[i]+=elements[(i+k)%elements.length];
				set.add(dp[i]);
			}
		}
		dp[0]+=dp[dp.length-1];
		set.add(dp[0]);
		return set.size();
	}
}