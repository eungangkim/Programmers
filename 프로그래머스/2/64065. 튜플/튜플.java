import java.util.*;
class Solution {
    public int[] solution(String s) {
		HashMap<Integer,Integer> counter=new HashMap<>();
		String [] set=s.replaceAll("\\{\\{","").replaceAll("\\}\\}","").split("},\\{");
		Arrays.sort(set,new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				String s1=(String)o1;
				String s2=(String)o2;
				
				return s1.length()-s2.length();
			}
		});
		
		int []answer=new int[set.length];
		
		for(int i=0;i<set.length;i++) {
			HashMap<Integer,Integer> clone=(HashMap<Integer, Integer>) counter.clone();
			String [] nums=set[i].split(",");
			for(int j=0;j<nums.length;j++) {
				int c=Integer.valueOf(nums[j]);
				if(!clone.containsKey(c)||clone.get(c)==0) {
					answer[i]=c;
					counter.put(c, counter.getOrDefault(c, 0)+1);
				}
				else {
					clone.put(c, clone.get(c)-1);
				}
			}
		}
		return answer;
	}
}