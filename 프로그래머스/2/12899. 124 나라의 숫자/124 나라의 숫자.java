class Solution {
    public String solution(int n) {
        StringBuilder sb=new StringBuilder();
        if(n<=2)return String.valueOf(n);
        else if(n==3)return "4";
        
        if(n%3==0) {
            sb.append(solution((n-3)/3));
        	sb.append("4");
        }
        else {
            sb.append(solution(n/3));
        	sb.append(String.valueOf((n%3)));
        }
        return sb.toString();
	}
}