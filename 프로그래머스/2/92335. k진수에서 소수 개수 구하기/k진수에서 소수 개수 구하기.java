class Solution {
   public int solution(int n, int k) {
		int answer=0;
		String numbers[]=Integer.toString(n,k).split("0");
		
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i].length()>0&&isPrime(Long.valueOf(numbers[i]))) {
				answer++;
			}
		}
		return answer;
	}
	public boolean isPrime(long n) {
		int sqrt=(int)Math.sqrt(n);
		if(n==1)return false;
		for(int i=2;i<=sqrt;i++) {
			if(n%i==0)return false;
		}
		return true;
	}
}