import java.util.Arrays;

class Solution {
   public int solution(int[] citations) {
    	int answer=0;
       Arrays.sort(citations);
    	while(citations.length-answer-1>=0&&answer<=citations[citations.length-answer-1]) {
    		answer++;
    	}
    	return answer<=citations[citations.length-answer]?answer:answer-1;
    }
}