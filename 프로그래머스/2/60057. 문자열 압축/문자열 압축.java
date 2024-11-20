class Solution {
    public int solution(String s) {
    	int min=s.length();
    	for(int i=1;i<=s.length()/2;i++)
    		min=Math.min(min, getCompressLength(s,i));
    	return min;
    }
    public int getCompressLength(String s,int k) {
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<s.length()&&i+k<=s.length();) {
    		String comS=s.substring(i,i+k);
    		int count=1;
    		while(s.length()>=i+k*(count+1)&&s.substring(i+k*count,i+k*(count+1)).equals(comS))
    			count++;
    		if(count!=1) 
    			sb.append(count);
    		sb.append(comS);
    		i+=count*k;
    	}
    	return sb.length()+s.length()%k;
    }
}