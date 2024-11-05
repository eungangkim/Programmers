class Solution {
    public int solution(String word) {
		int answer =0;
		int gap=781;
		char []character={'A','E','I','O','U'};
		for(int i=0;i<word.length();i++) {
			char c=word.charAt(i);
			for(int j=0;j<5;j++) {
				if(character[j]==c) {
					answer+=gap*j+1;
					break;
				}
			}
			gap/=5;
		}
		return answer;
	}
}