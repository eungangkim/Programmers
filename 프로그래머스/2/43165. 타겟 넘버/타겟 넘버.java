class Solution {
    public int solution(int[] numbers, int target) { 
		return dfs(numbers,target,0,0);
	}
	public int dfs(int[] numbers,int target,int sum,int k) {
		int cnt=0;
		if(k==numbers.length) {
			if(target==sum)return 1;
			return 0;
		}
		return dfs(numbers,target,sum+numbers[k],k+1)+dfs(numbers,target,sum-numbers[k],k+1);
	}
}