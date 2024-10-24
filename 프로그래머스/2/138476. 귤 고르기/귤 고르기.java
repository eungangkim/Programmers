
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(int k, int[] tangerine) {
		HashMap<Integer,Integer> map=new HashMap<>();
		ArrayList<Integer> vals;
		for(int i:tangerine) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		
		vals=new ArrayList<>(map.values());
		
		vals.sort((a,b)->b-a);
		
		for(int i=0;i<vals.size();i++) {
			k-=vals.get(i);
			if(k<=0)return i+1;
		}
		
		return vals.size();
	}
}