
import java.util.Stack;
class Solution {
    public int solution(int[] order) {
		Stack<Integer> helper=new Stack<Integer>();
		int nextBox=0;
		
		for(int i=1;i<=order.length;i++) {
			if(i==order[nextBox]) nextBox++;
			else helper.push(i);
            while(!helper.isEmpty()&&order[nextBox]==helper.peek()) {
				helper.pop();
				nextBox++;
			}
		}
		return nextBox;
	}
}