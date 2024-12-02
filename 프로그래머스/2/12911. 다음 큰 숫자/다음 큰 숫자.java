class Solution{
    public int solution(int n) {
		StringBuilder sb=new StringBuilder();
		String nString=Integer.toBinaryString(n);
		boolean findOne=false;
		int countOne=0;
		for(int i=nString.length()-1;i>=0;i--) {
			char c=nString.charAt(i);
			if(findOne&&c=='0') {
				sb.append(nString.substring(0, i));
				sb.append("10");
				for(int j=0;j<nString.length()-i-countOne-1;j++) {
					sb.append("0");
				}
				for(int j=0;j<countOne-1;j++) {
					sb.append("1");
				}
                break;
			}
			else if(c=='1') {
				countOne++;
				findOne=true;
			}
		}
        if(sb.length()==0) {
            sb.append("10");
        	sb.append("0".repeat(nString.length()-countOne));
        	sb.append("1".repeat(countOne-1));
        }
        return Integer.parseInt(sb.toString(),2);
	}
}