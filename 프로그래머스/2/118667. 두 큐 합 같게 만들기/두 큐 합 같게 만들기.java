import java.util.ArrayDeque;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
		ArrayDeque<Integer> deque1=new ArrayDeque<>(),deque2=new ArrayDeque<>();
		long sum1=0,sum2=0;
		int answer=0;
        int limit=queue1.length*2+1;
		for(int i=0;i<queue1.length;i++) {
			sum1+=queue1[i];
			deque1.add(queue1[i]);
			sum2+=queue2[i];
			deque2.add(queue2[i]);
		}
		while(sum1!=sum2&&answer<=limit) {
			int number=0;
			answer++;
			if(sum1<sum2) {
				number=deque2.poll();
				deque1.add(number);
				sum1+=number;
				sum2-=number;
			}
			else {
				number=deque1.poll();
				deque2.add(number);
				sum2+=number;
				sum1-=number;
			}
		}
		return sum1!=sum2?-1:answer;
	}

}