import java.util.PriorityQueue;

class Solution{ 
    public int solution(int[] picks, String[] minerals) {
		PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
		int picksN=picks[0]+picks[1]+picks[2];
		int answer=0;
		for(int i=0;i<Math.min(picksN*5, minerals.length);i+=5) {
			int sum=0;
			for(int j=i;j<Math.min(picksN*5, Math.min(minerals.length, i+5));j++) {
				sum+=minerals[j].equals("diamond")?31:minerals[j].equals("iron")?6:1;
			}
			queue.add(sum);
		}
		
		while(!queue.isEmpty()&&picksN>0) {
			int pick=-1;
			int mineral=queue.poll();
			for(int i=0;i<3;i++) {// 0=다이아 곡 1=철 곡 2=돌 곡
				if(picks[i]>0) {
					pick=i;
					picks[i]--;
                    break;
				}
			}
			while(mineral>0) {
				if(mineral/31>0) {
					mineral-=31;
					answer+=Math.pow(5, pick);
				}
				else if(mineral/6>0) {
					mineral-=6;
					answer+=Math.pow(5, pick>0?pick-1:pick);
				}
				else if(mineral/1>0) {
					mineral-=1;
					answer++;
				}
			}
		}
		return answer;
	}
}