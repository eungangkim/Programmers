import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	int maxLength[];
	public String[] solution(String[] orders, int[] course) {
		HashMap<String,Integer> frequencys[]=new HashMap[9];
		ArrayList<String> answerList=new ArrayList<>();
		String []answer;
		maxLength=new int[9];
		
		initFrequencys(orders,frequencys);
		
		for(int i=0;i<course.length;i++) {
			if(maxLength[course[i]-2]<2)continue;
			for(Entry<String,Integer> entry:frequencys[course[i]-2].entrySet()) {
				if(entry.getValue()==maxLength[course[i]-2])answerList.add(entry.getKey());
			}
		}
		
		answerList.sort(null);
		answer=new String[answerList.size()];
		
		for(int i=0;i<answer.length;i++) {
			answer[i]=answerList.get(i);
		}
		
		return answer;
	}
	public void initFrequencys(String[] orders,HashMap<String,Integer>[] frequencys) {
		for(int i=0;i<orders.length;i++) {
			bfs(0,orders[i],new StringBuilder(),frequencys);
		}
	}
	public void bfs(int k,String s,StringBuilder sb,HashMap<String,Integer>[] frequencys) {
		if(sb.length()>=2) {
			int idx=sb.length()-2;
			String key=sort(sb.toString());
			if(frequencys[idx]==null)frequencys[idx]=new HashMap<>();
			frequencys[idx].put(key,frequencys[idx].getOrDefault(key, 0)+1);
			maxLength[idx]=Math.max(maxLength[idx],frequencys[idx].get(key));
		}
		//if(k>=s.length())return;
		for(int i=k;i<s.length();i++) {
			sb.append(s.charAt(i));
			bfs(i+1,s,sb,frequencys);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	public String sort(String s) {
		char chars[]=s.toCharArray();
		StringBuilder sb=new StringBuilder();
		
		Arrays.sort(chars);
		for(int i=0;i<chars.length;i++) {
			sb.append(chars[i]);
		}
		
		return sb.toString();
	}
}