import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
		
		ArrayList<String> set1=new ArrayList<>();
		ArrayList<String> set2=new ArrayList<>();
		int idx1=0,idx2=0,length1,length2;
		double union=0,intersection=0;
		
		getSet(set1,str1.toLowerCase(),0);
		getSet(set2,str2.toLowerCase(),0);
		
		set1.sort(null);
		set2.sort(null);
		
        length1=set1.size();
        length2=set2.size();
        
		while(idx1<length1&&idx2<length2) {
			String s1=set1.get(idx1),s2=set2.get(idx2);
			int cmp=s1.compareTo(s2);
			if(cmp<0) {
				idx1++;
			}
			else if(cmp>0) {
				idx2++;
			}
			else {
				intersection++;
				idx1++;
				idx2++;
			}
			union++;
		}
		union+=(length1-idx1)+(length2-idx2);
        if(union==0)return 65536;
		return (int)(Math.floor(intersection/union*65536));
		
	}
	public void getSet(ArrayList<String> set,String str,int k) {
		char current=str.charAt(0);
		for(int i=1;i<str.length();i++) {
			char next=str.charAt(i);
			if('a'<=current&&current<='z'&&'a'<=next&&next<='z') {
				set.add(String.valueOf(current)+String.valueOf(next));
			}
			current=next;
		}
	}
}