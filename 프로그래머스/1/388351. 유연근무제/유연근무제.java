class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i=0;i<schedules.length;i++) {
        	int deadline=schedules[i]+10,cnt=0;
        	if((schedules[i]+10)%100>59) {
        		int hour=schedules[i]/100+1;
        		int minute=schedules[i]%100-50;
        		deadline=hour*100+minute;
        	}
        	for(int j=0;j<7;j++) {
        		if((j+startday-1)%7>=5)continue;
        		if(timelogs[i][j]<=deadline)cnt++;
        	}
        	if(cnt==5)answer++;
        }
        return answer;
    }
}