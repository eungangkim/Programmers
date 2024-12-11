class Solution {
    public int[] solution(int e, int[] starts) {
        int []answer=new int[starts.length],count=new int[e],maxNumbers=new int[e];
        int maxCount=0,maxNumber=0;
        int sqrtOfe=(int)Math.sqrt(e);
        for(int i=1;i<=sqrtOfe;i++) {
        	int number=i*i;
            count[number-1]--;
        	while(number<=e) {
        		count[number-1]+=2;
        		number+=i;
        	}
        }
        
        maxNumber=e-1;
        for(int i=count.length-1;i>=0;i--) {
        	if(count[maxNumber]<=count[i])maxNumber=i;
        	maxNumbers[i]=maxNumber+1;
        }
        
        for(int i=0;i<answer.length;i++) {
        	answer[i]=maxNumbers[starts[i]-1];
        }
        return answer;
    }
}