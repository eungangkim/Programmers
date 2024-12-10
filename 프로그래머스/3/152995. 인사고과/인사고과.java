import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] scores) {
        int passCount = 1;
        int myScores[]=scores[0];
        int myScore=scores[0][0]+scores[0][1];
        Arrays.sort(scores,(a,b)->b[0]==a[0]?b[1]-a[1]:b[0]-a[0]);
        ArrayList<Integer> maxIndexEachSection=new ArrayList<>();
        for(int i=0;i<scores.length;i++) {
            if(myScore>=(scores[i][0]+scores[i][1]))continue;
            boolean pass=isPass(scores[i],maxIndexEachSection,scores);
        	if(pass)passCount++;
            if(i==0||(scores[i-1][0]!=scores[i][0]&&pass))maxIndexEachSection.add(i);
        }
        if(!isPass(myScores,maxIndexEachSection,scores))return -1;

        return passCount;
    }
	public boolean isPass(int []score,ArrayList<Integer> maxIndexEachSection,int [][]scores) {
		for(int index:maxIndexEachSection) {
            if(score[0]==scores[index][0])break;
			else if(score[0]<scores[index][0]&&score[1]<scores[index][1])return false;
		}
		return true;
	}
}