import java.util.Arrays;
class Solution {
   public int solution(int[] people, int limit) {
		Arrays.sort(people);
		int count=0,heavyIdx=people.length-1,lightIdx=0;
		while(heavyIdx>=lightIdx) {
			int weight=people[heavyIdx--];
			if(weight+people[lightIdx]<=limit) {
				lightIdx++;
			}
			count++;
		}
		return count;
	}
}