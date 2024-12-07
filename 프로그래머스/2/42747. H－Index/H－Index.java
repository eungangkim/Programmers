import java.util.Arrays;

class Solution {
   public int solution(int[] citations) {
		int length=citations.length;
		Arrays.sort(citations);
		for(int hIndex=length;hIndex>0;hIndex--) {
			if(citations[length-hIndex]>=hIndex)return hIndex;
		}
		return 0;
	}
}