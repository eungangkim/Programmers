class Solution {
    public int solution(int storey) {
		int answer=0;
		while(storey>0) {
			int next=(storey%100)/10;
			if(next>=5&&storey%10==5) {
				answer+=10-(storey%10);
                storey+=10;
			}
			else if(storey%10>5){

				answer+=10-(storey%10);
                storey+=10;
			}
			else 
				answer+=storey%10;
			storey/=10;
		}
		return answer;
	}
}