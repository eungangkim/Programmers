import java.util.ArrayList;
class Solution {
   public int[] solution(int n, long k) {
		ArrayList<Integer> bucket=new ArrayList<>();
		int answer[]=new int[n];
		long nOfcase=factorial(n);
        int idx=0;
		
		for(int i=1;i<=n;i++)
			bucket.add(i);
		
		k--;
		
		while(bucket.size()!=0) {
            nOfcase/=n;
			answer[idx++]=bucket.remove((int)(k/nOfcase));
			k%=nOfcase;
			n--;
		}
		return answer;
	}
	public long factorial(int n) {
		if(n==1)return 1;
		return n*factorial(n-1);
	}
}