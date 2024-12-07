

class Solution {
    public int solution(int n, long l, long r) {
    	int cnt=0;
    	for(long i=l-1;i<r;i++) {
    		if(i%5==2)continue;
    		long temp=i;
    		while(temp>=5) {
    			if(temp%5==2)    				
    				break;
    			temp/=5;
    		}
    		if(temp%5!=2){
                cnt++;
            }
    	}
    	return cnt;
    }
}