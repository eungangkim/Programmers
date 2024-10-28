class Solution {
    public int solution(int[] topping) {
		int [] rightTopping=new int[10000],leftTopping=new int[10000];
		int leftToppingCount=0,rightToppingCount=0;
		int answer=0;
		
		for(int t:topping) {
			if(rightTopping[t-1]++==0)rightToppingCount++;
		}
		
		for(int t:topping) {
			if(--rightTopping[t-1]==0)rightToppingCount--;
			if(leftTopping[t-1]++==0)leftToppingCount++;
			if(leftToppingCount==rightToppingCount)answer++;
			else if(leftToppingCount>rightToppingCount)break;
		}
		
		return answer;
	}
}