import java.util.HashMap;
import java.util.Map.Entry;
class Solution {
   public int solution(String[][] clothes) {
		HashMap<String,Integer> map=new HashMap<>();
		int answer=1;
		
		for(int i=0;i<clothes.length;i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
		}
		
		for(Entry<String, Integer> x:map.entrySet()) {
			answer*=(x.getValue()+1);
		}
		return answer-1;
	}
}