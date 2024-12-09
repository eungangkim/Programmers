import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int reqsByType[][][]=initReqs(k,reqs);
		int agentsByType[] = new int[k];
        int watingTimeByNOfAgent[][]=new int[k][];
        int totalWatingTime=0;
        for(int i=0;i<k;i++) {
        	watingTimeByNOfAgent[i]=getWatingTimeByNOfAgent(n-k+1,reqsByType[i]);
        }
        for(int i=0;i<n-k;i++) {
        	int maxIdx=getMaxDeltaIdx(watingTimeByNOfAgent,agentsByType);
        	agentsByType[maxIdx]++;
        }
        
        return getTotalWatingTime(watingTimeByNOfAgent,agentsByType);
	}
	public int[][][] initReqs(int k,int[][] reqs){
		int [][][] reqsByType=new int[k][][];
		int nOfReqsByType[]=new int[k];
		for(int i=0;i<reqs.length;i++) {
			nOfReqsByType[reqs[i][2]-1]++;
		}
		for(int i=0;i<k;i++) {
			reqsByType[i]=new int[nOfReqsByType[i]][2];
		}
		for(int i=0;i<reqs.length;i++) {
			int type=reqs[i][2]-1;
			int length=reqsByType[type].length,idx=nOfReqsByType[type]--;
			reqsByType[type][length-idx]=reqs[i];
		}
		return reqsByType;
	}
	public int[] getWatingTimeByNOfAgent(int maxNOfAgent,int reqs[][]) {
		int watingTime[]=new int[maxNOfAgent];
		for(int i=0;i<maxNOfAgent;i++) {
			watingTime[i]=getWatingTime((i+1),reqs);
		}
		return watingTime;
	}
	public int getWatingTime(int nOfAgent,int [][]reqs) {
		int totalWatingTime=0,reqsIdx=0,lastDoneTime=0;
		PriorityQueue<Integer> consulting=new PriorityQueue<>((a,b)->a-b);
		PriorityQueue<Integer> watingIdx=new PriorityQueue<>((a,b)->a-b);
		while(!consulting.isEmpty()||!watingIdx.isEmpty()||reqsIdx<reqs.length) {
			if(nOfAgent>consulting.size()&&(!watingIdx.isEmpty()||reqsIdx<reqs.length)) {
				int idx=-1;
				int watingTime=0;
				if(!watingIdx.isEmpty()) {
					idx=watingIdx.poll();
					watingTime=lastDoneTime-reqs[idx][0];
					totalWatingTime+=watingTime;
				}
				else {
					idx=reqsIdx++;
				}
				consulting.add(reqs[idx][0]+reqs[idx][1]+watingTime);
			}
			else {
				lastDoneTime=consulting.poll();
				while(reqsIdx<reqs.length&&reqs[reqsIdx][0]<=lastDoneTime)
					watingIdx.add(reqsIdx++);
			}
		}
		return totalWatingTime;
	}
	public int getMaxDeltaIdx(int [][]watingTimeByNOfAgent,int []agentsByType) {
		int maxIdx=0;
    	int maxDeltaWatingTime=watingTimeByNOfAgent[0][agentsByType[0]]-watingTimeByNOfAgent[0][agentsByType[0]+1];
    	for(int j=1;j<watingTimeByNOfAgent.length;j++) {
        	int deltaWatingTime=watingTimeByNOfAgent[j][agentsByType[j]]-watingTimeByNOfAgent[j][agentsByType[j]+1];
    		if(maxDeltaWatingTime<deltaWatingTime) {
    			maxIdx=j;
    			maxDeltaWatingTime=deltaWatingTime;
    		}
    	}
    	return maxIdx;
	}
	public int getTotalWatingTime(int [][]watingTimeByNOfAgent,int []agentsByType) {
		int totalWatingTime=0;
		for(int i=0;i<watingTimeByNOfAgent.length;i++) {
			totalWatingTime+=watingTimeByNOfAgent[i][agentsByType[i]];
		}
		return totalWatingTime;
	}
    public void show(int [][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
