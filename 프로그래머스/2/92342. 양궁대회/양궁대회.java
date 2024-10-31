
import java.util.PriorityQueue;

class Solution {
    PriorityQueue<int []> queue;
    public int[] solution(int n, int[] info) {
    	int answer[];
    	queue=new PriorityQueue<>((a,b)->{
    		int pointA=getPointDifference(info,a);
    		int pointB=getPointDifference(info,b);
    		if(pointA!=pointB)return pointB-pointA;
    		for(int i=10;i>=0;i--) {
    			if(a[i]!=b[i])
    				return b[i]-a[i];
    		}
    		return 0;
    	});
    	bfs(0,n,info,new int[11]);
    	answer=queue.poll();
    	if(getPointDifference(info,answer)<=0) {
    		return new int[] {-1};
    	}
    	return answer;
    }
    public void bfs(int k,int n,int apeach[],int lion[]) {
    	if(k==10||n<=0) {
    		lion[10]=n;
    		queue.add(lion.clone());
    		return;
    	}
    	//10-k 점수를 따는 경우
    	if(apeach[k]<n) {
    		lion[k]=apeach[k]+1;
    		bfs(k+1,n-apeach[k]-1,apeach,lion);
    		lion[k]=0;
    	}
    	// 점수를 따지 않는 경우
    	bfs(k+1,n,apeach,lion);
    }
    public int getPointDifference(int []apeach,int []lion) {
    	int pointDiff=0;
    	for(int i=0;i<10;i++) {
    		if(lion[i]>0) {
    			pointDiff+=(10-i);
    		}
    		else if(apeach[i]>0) {
    			pointDiff-=(10-i);
    		}
    	}
    	return pointDiff;
    }
}