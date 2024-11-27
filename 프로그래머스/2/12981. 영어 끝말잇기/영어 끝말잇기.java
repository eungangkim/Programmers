import java.util.HashSet;
class Solution {
    public int[] solution(int n, String[] words) {
		int turn=1;
		HashSet<String> set=new HashSet<>();
		
		set.add(words[0]);
		
		for(int i=1;i<words.length;i++) {
			if(!set.add(words[i])||words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0))return new int[] {turn+1,i/n+1};
			turn=(turn+1)%n;
		}
		return new int[] {0,0};
	}
}