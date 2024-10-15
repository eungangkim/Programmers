import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        ArrayList<Integer> indexes=new ArrayList<>();
        HashSet<Integer> prime_numbers=new HashSet<>();
        
        for(int i=0;i<numbers.length();i++) {
        	indexes.add(i);
        }
        dfs(numbers,"",indexes,prime_numbers) ;
        return prime_numbers.size();
    }
	public void dfs(String numbers,String num,ArrayList<Integer> indexes,HashSet<Integer> set) {
		//System.out.println(num);
        if(num.length()>0&&isPrime(Integer.valueOf(num))) {
			set.add(Integer.valueOf(num));
		}
		for(int i=0;i<indexes.size();i++) {
			int index=indexes.remove(i);
	        dfs(numbers,num+numbers.charAt(index),indexes,set) ;
	        indexes.add(i,index);
		}
	}
	public boolean isPrime(int n) {
        if(n<2)return false;
		int sqrt=(int) Math.sqrt(n);
		for(int i=2;i<=sqrt;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}