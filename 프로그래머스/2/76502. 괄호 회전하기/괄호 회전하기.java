
import java.util.Stack;
class Solution {
	public int solution(String s) {
		int answer=0;
        StringBuilder sb = new StringBuilder(s);

		for(int i=0;i<s.length();i++) {
			sb.append(sb.charAt(0));
			sb.deleteCharAt(0);
			if(isRight(sb.toString()))
				answer++;
		}
		return answer;
	}
	public boolean isRight(String s) {
		Stack<Character> stack=new Stack<>();
		char []paren= {'[','{','(',']','}',')'};
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='['||c=='{'||c=='(')
				stack.push(c);
			else if(!stack.isEmpty()) {
				char mate =stack.pop();
				for(int j=0;j<3;j++) {
					if(paren[j]==mate){
                        if(paren[j+3]!=c) 
						    return false;
                        break;
					}
				}
			}
			else return false;
		}
        if(!stack.isEmpty())return false;
		return true;
	}
}