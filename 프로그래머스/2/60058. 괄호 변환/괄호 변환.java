import java.util.Stack;
class Solution {
    public String solution(String p) {
		if(p.length()==0)return "";
		StringBuilder sb=new StringBuilder();
		String []uv=split(p);
		if(isRight(uv[0])) {
			sb.append(uv[0]);
			sb.append(solution(uv[1]));
		}
		else {
			sb.append("(");
			sb.append(solution(uv[1]));
			sb.append(")");
			for(int i=1;i<uv[0].length()-1;i++) {
				if(uv[0].charAt(i)=='(')
					sb.append(")");
				else
					sb.append("(");
			}
		}
		return sb.toString();
	}
	public String[] split(String p) {
		int [] count= {0,0};
		for(int i=0;i<p.length();i++) {
			char c=p.charAt(i);
			if(c=='(')
				count[0]++;
			else if(c==')')
				count[1]++;
			if(count[0]==count[1])
				return new String[] {p.substring(0,i+1),p.substring(i+1,p.length())};
		}
		return new String[] {p,""};
	}
	public boolean isRight(String u) {
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<u.length();i++) {
			if(u.charAt(i)=='(')
				stack.push('(');
			else if(stack.isEmpty()||stack.pop()!='('){
				return false;
			}
		}
		return true;
	}
}