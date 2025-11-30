class Solution {
    public int solution(int n, int w, int num) {
        if(w==1)return n-num+1;
        
        int answer=n/w-((num-1)/w);
        
        if(n%w==0)return answer;

        boolean lastFloorisOdd=(((n-1)/w)+1)%2==1;
        int indexOfLast=lastFloorisOdd?(n-1)%w:w-(n-1)%w-1;
        
        int floorOfNum=((num-1)/w)+1;
        int indexOfNum=floorOfNum%2==1?(num-1)%w:w-(num-1)%w-1;
        
        if(lastFloorisOdd) {
        	if(indexOfNum<=indexOfLast)answer++;
        }
        else {
        	if(indexOfNum>=indexOfLast)answer++;
        }
        return answer;
    }
}