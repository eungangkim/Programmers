class Solution {
    public int solution(int[] players, int m, int k) {
        int start=0,finish=k-1;
        int []serverQueue=new int[k];
        int numOfServer=0,runningServer=0;

        for(int n:players){
            int additionServer=n/m;
            runningServer-=serverQueue[start];
            start=(start+1)%k;finish=(finish+1)%k;
            serverQueue[finish]=0;
            if(additionServer>runningServer){
                int as=additionServer-runningServer;
                serverQueue[finish]=as;
                runningServer+=as;
                numOfServer+=as;
            }
            
        }
        return numOfServer;
    }
}