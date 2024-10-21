import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
  public String[] solution(String[][] plans) {
		PriorityQueue<int []> queue=new PriorityQueue<>((a,b)->a[1]-b[1]);
		Stack<int[]> stack=new Stack<>();
		String []names=new String[plans.length];
		String []answer=new String[plans.length];
		int answerIdx=0;
		for(int i=0;i<plans.length;i++) {
			names[i]=plans[i][0];
			queue.add(new int[] {i,Integer.valueOf(plans[i][1].substring(0,2))*60+Integer.valueOf(plans[i][1].substring(3,5)),Integer.valueOf(plans[i][2])});
		}
		while(!queue.isEmpty()||!stack.isEmpty()) {
			int []project;
			int []next;
			int restTime=0;

			if(!queue.isEmpty()) {
				project=queue.poll();
				if(!queue.isEmpty())next=queue.peek();
				else next=new int[] {0,1539,0};
				if(project[1]+project[2]<=next[1]) {
					answer[answerIdx++]=names[project[0]];
					restTime=next[1]-(project[1]+project[2]);
				}
				else {
					project[2]=project[1]+project[2]-next[1];
					stack.push(project);
				}
			}
			else{
				restTime=Integer.MAX_VALUE;
            }
			while(!stack.isEmpty()&&restTime>0) {
				project=stack.pop();
				if(project[2]<=restTime) {
					answer[answerIdx++]=names[project[0]];
					restTime-=project[2];
				}
				else {
					project[2]-=restTime;
					stack.push(project);
					break;
				}
			}
		}
		return answer;
	}
}