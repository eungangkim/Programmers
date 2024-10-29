import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
    	HashMap<String,Integer> map=new HashMap<>();
    	boolean flag=false;
    	int answer=0;
    	
    	for(int i=0;i<10;i++) {
    		map.put(discount[i], map.getOrDefault(discount[i], 0)+1);
    	}
    	if(check(want,number,map)) {
    		flag=true;
    		answer++;
    	}
    	for(int i=10;i<discount.length;i++) {
    		if(flag&&discount[i].equals(discount[i-10])) {
    			answer++;
    		}
    		else {
    			map.put(discount[i-10], map.get(discount[i-10])-1);
    			map.put(discount[i], map.getOrDefault(discount[i],0)+1);
    			flag=false;
    			if(check(want,number,map)) {
    				flag=true;
    				answer++;
    			}
    		}
    	}
    	return answer;
    }
    public boolean check(String[] want,int[]number,HashMap<String,Integer> map) {
    	for(int i=0;i<want.length;i++) {
    		if(map.getOrDefault(want[i],0)!=number[i]) {
    			return false;
    		}
    	}
    	return true;
    }
}