class Solution {
    public long solution(int[] sequence) {  
        long sum1 = 0,sum2=0,maxSum=0;
    	int []pulse= {1,-1};

        for(int i=0;i<sequence.length;i++) {
        	sum1+=sequence[i]*pulse[i%2];
        	sum2+=sequence[i]*pulse[(i+1)%2];
        	if(sum1<0)sum1=0;
        	if(sum2<0)sum2=0;
        	maxSum=Math.max(maxSum, Math.max(sum2, sum1));
        }
        return maxSum;
    }
}