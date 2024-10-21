class Solution {
    public long solution(int r1, int r2) {
		long answer=0;
		
		for(int x=0;x<=r2;x++) {
			double start;
            if(r1<=x)
                start=1;
            else{
                start=Math.sqrt((long)r1*r1-(long)x*x);
                if(start!=Math.floor(start)) {
                    start=Math.floor(start)+1;
                }
            }
                
			double finish=Math.floor(Math.sqrt((long)r2*r2-(long)x*x));
			if(finish!=Math.floor(finish)) {
                finish=Math.floor(finish)+1;
            }
			else {
				answer++;
			}
			answer+=finish-start;
		}
		return answer*4;
	}
}