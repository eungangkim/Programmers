
import java.util.ArrayDeque;

class Solution {
    public int solution(int cacheSize, String[] cities) {
		ArrayDeque<String >queue=new ArrayDeque<>();
		int totalTime=0;
         if(cacheSize==0)return cities.length*5;
		for(int i=0;i<cities.length;i++) {
			cities[i]=cities[i].toLowerCase();
			if(queue.contains(cities[i])) {
				queue.remove(cities[i]);
				queue.add(cities[i]);
				totalTime++;
			}
			else{
				if(queue.size()>=cacheSize) {
					queue.poll();
				}
				queue.add(cities[i]);
				totalTime+=5;
			}
		}
		return totalTime;
	}
}