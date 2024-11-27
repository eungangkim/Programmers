import java.util.ArrayList;
class Solution {
    public String solution(String m, String[] musicinfos) {
		String [] usualDigit= {"C#","D#","F#","G#","A#","B#"};
		String [] replaceDigit= {"H","I","J","K","L","M"};
		int max=0;
		String answer="(None)";
		m=replace(m,usualDigit,replaceDigit);

		for(String info:musicinfos) {
			String infos[]=info.split(",");
			int playedTime=toMinute(infos[1])-toMinute(infos[0]);
			infos[3]=replace(infos[3],usualDigit,replaceDigit);
			
			String totalMelody=infos[3].repeat(playedTime/infos[3].length()+1).substring(0,playedTime);
			if(totalMelody.contains(m)&&max<playedTime) {
				max=playedTime;
				answer=infos[2];
			}	
		}
		return answer;
	}
	public String replace(String m,String []usualDigit,String []replaceDigit) {
		for(int i=0;i<usualDigit.length;i++)
			m=m.replaceAll(usualDigit[i], replaceDigit[i]);
		return m;
	}
	public int toMinute(String time) {
		return Integer.valueOf(time.substring(0, 2))*60+Integer.valueOf(time.substring(3,5));
	}
}