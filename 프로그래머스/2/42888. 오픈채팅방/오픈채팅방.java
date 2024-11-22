import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
		String [] answer;
		ArrayDeque<String[]> recordQueue=new ArrayDeque<>();
		HashMap<String,String> niknames=new HashMap<>();
		
		for(int i=0;i<record.length;i++) {
			String[] infos=record[i].split(" ");
			if(!infos[0].equals("Change"))recordQueue.add(infos);
			if(!infos[0].equals("Leave"))
                niknames.put(infos[1], infos[2]);
		}
		
		answer=new String[recordQueue.size()];
		int idx=0;
		while(!recordQueue.isEmpty()) {
			String info[]=recordQueue.poll();
			if(info[0].equals("Enter")) {
				answer[idx++]=niknames.get(info[1])+"님이 들어왔습니다.";
			}
			else {
				answer[idx++]=niknames.get(info[1])+"님이 나갔습니다.";
			}
		}
		
		return answer;
	}
}