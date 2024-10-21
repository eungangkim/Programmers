
class Solution {
    public int[] solution(int[] sequence, int k) {
		int answer[]=new int[] {0,sequence.length};
		int finish=sequence.length-1;
		int sum=0;
		for(int i=sequence.length-1;i>=0;i--) {
			sum+=sequence[i];
			
			while(sum>k) {
				sum-=sequence[finish--];
			}
            if(sum==k&&answer[1]-answer[0]>=finish-i) {
				answer[0]=i;
				answer[1]=finish;
			}
		}
		return answer;
	}
}