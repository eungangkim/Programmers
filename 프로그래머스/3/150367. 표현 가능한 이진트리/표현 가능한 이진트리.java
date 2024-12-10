class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++) {
        	String binaryString=getBinaryString(numbers[i]);
        	answer[i]=isLink(binaryString)?1:0;
        }
        return answer;
    }
	public String getBinaryString(long n) {
		StringBuilder sb=new StringBuilder(Long.toBinaryString(n));
		int nOfNode=getSize(sb.length());
		while(sb.length()<nOfNode)sb.insert(0, "0");
		return sb.toString();
	}
	public int getSize(int length) {
		int size=1;
		while(size*2-1<length)size*=2;
		return size*2-1;
	}
	public boolean isLink(String binaryString) {
		return dfs(0,binaryString.length()-1,binaryString);
	}
	public boolean dfs(int start,int finish,String binaryString) {
		if(start>=finish)return true;
		int rootIdx=(start+finish)/2;
		if(binaryString.charAt(rootIdx)=='1') {
			if(dfs(start,rootIdx-1,binaryString)&&dfs(rootIdx+1,finish,binaryString))
				return true;
            return false;
		}
		else {
			for(int i=start;i<=finish;i++) {
				if(binaryString.charAt(i)=='1')return false;
			}
		}
		return true;
	}
}