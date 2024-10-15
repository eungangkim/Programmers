
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Solution {
   	public String solution(int[] numbers) {
        StringBuilder sb=new StringBuilder();
		PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a,Integer b) {
				String as=String.valueOf(a),bs=String.valueOf(b),longString=as.length()>bs.length()?as:bs,shortString=as.length()>bs.length()?bs:as;
				int idxA=0,idxB=0,length=Math.max(as.length(), bs.length());
				while(idxA<length&&idxB<length) {
					char ac=as.charAt(idxA%as.length()),bc=bs.charAt(idxB%bs.length());
					if(ac!=bc)return bc-ac;
                    idxA++;
                    idxB++;
				}
				return bs.charAt(bs.length()-1)-as.charAt(as.length()-1);
			}
		});
		for(int i:numbers) {
			queue.add(i);
		}
		while(!queue.isEmpty()){
            int i=queue.poll();
            //System.out.println(i);
			sb.append(i);
        }
		if(sb.charAt(0)=='0')return "0";
		return sb.toString();
    }
}