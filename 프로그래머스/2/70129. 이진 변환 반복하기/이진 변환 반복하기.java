class Solution {
    public int[] solution(String s) {
		int answer[]=new int[2];
		
		while(!s.equals("1")) {
			String deleteZero=s.replaceAll("0", "");
			answer[1]+=s.length()-deleteZero.length();
			s=Integer.toString(deleteZero.length(), 2);
			answer[0]++;
		}
		
		return answer;
	}
}