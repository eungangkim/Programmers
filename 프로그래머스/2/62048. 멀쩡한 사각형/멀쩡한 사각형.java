class Solution {
   public long solution(int w, int h) {
		int maxDivisor=getMaxDivisor(w,h);
    System.out.println(maxDivisor);
		return (long)w*h-(w+h-maxDivisor);
	}
	public int getMaxDivisor(int w,int h) {
		int small=w<h?w:h;
		int big=w<h?h:w;
		for(int i=small;i>0;i--) {
			if(small%i==0&&big%i==0)return i;
		}
		return -1;
	}
}