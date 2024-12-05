class Solution {
    public String solution(String s) {
		StringBuilder sb=new StringBuilder();
		boolean flag=true;
		
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c==' ') {
				flag=true;
			}
			else if(flag){
                if('a'<=c&&c<='z') 
				    c-=32;
				flag=false;
			}
            else if('A'<=c&&c<='Z')
                c+=32;
			sb.append(c);
		}
		return sb.toString();
	}
}