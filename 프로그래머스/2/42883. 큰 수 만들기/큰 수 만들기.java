
class Solution {
	public String solution(String number, int k) {
		StringBuilder sb=new StringBuilder();
		
		sb.append(number.charAt(0));
		for(int i=1;i<number.length();i++) {
			while(k>0&&sb.length()>0&&sb.charAt(sb.length()-1)<number.charAt(i)) {
                k--;
                sb.deleteCharAt(sb.length()-1);
            }
			sb.append(number.charAt(i));
		}
		sb.delete(sb.length()-k, sb.length());
		return sb.toString();
	}
}
