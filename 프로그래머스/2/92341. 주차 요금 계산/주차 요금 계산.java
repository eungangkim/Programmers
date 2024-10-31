import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {

    public int[] solution(int[] fees, String[] records) {
		HashMap<Integer,Car> map=new HashMap<>();
		PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->a-b);
		int []answer;
		for(int i=0;i<records.length;i++) {
			String info[]=records[i].split(" ");
			int id=Integer.valueOf(info[1]);
			Car car;
			if(!map.containsKey(id)) {
				queue.add(id);
				car=new Car();
				map.put(id, car);
			}
			else {
				car=map.get(id);
			}
			car.setInfo(info[0]);
		}
		
		answer=new int[queue.size()];
		for(int i=0;i<answer.length;i++) {
			Car car=map.get(queue.poll());
			answer[i]=car.settleTheAcounts(fees);
		}
		return answer;
	}
	class Car{
		
		int useTime,arrivalTime;
		boolean In;
		public Car() {
			useTime=0;
			In=false;
		}
		public void setInfo(String s) {
			String timeS[]=s.split(":");
			int time=Integer.valueOf(timeS[0])*60+Integer.valueOf(timeS[1]);
			if(In==false) {
				arrivalTime=time;
				In=true;
			}
			else {
				useTime+=time-arrivalTime;
				In=false;
			}
		}
		public int settleTheAcounts(int []fees) {
			int fee=0;
			if(In==true) {
				useTime+=(1439-arrivalTime);
				In=false;
			}
			if(useTime>fees[0]) {
				fee+=fees[1];
				useTime-=fees[0];
				fee+=(Math.ceil(useTime/(double)fees[2])*fees[3]);
			}
			else {
				fee+=fees[1];
			}
			return fee;
		}
	}
}