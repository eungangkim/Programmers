class Solution {
    public int solution(String name) {
		return dfs(0,1,name.length()-1,name);
	}
	public int dfs(int idx,int left,int right,String name) {
		int answer=0;
		int leftMove=0,rightMove=0;
		char c=name.charAt(idx);
		answer+=Math.min((c-'A'),'Z'-c+1 );
		if(idx==left)
			left++;
		if(idx==right)
			right--;
		while(left<name.length()&&name.charAt(left)=='A') {
			left++;
		}
		while(right>=0&&name.charAt(right)=='A') {
			right--;
		}
        if(left>right)return answer;;
        if(idx<left) {
        	rightMove=left-idx;
           	leftMove=name.length()-right+idx;
        }
        else {
        	rightMove=left+name.length()-idx;
           	leftMove=idx-right;
        }
        int rightMoveAnswer=dfs(left,left,right,name)+rightMove;
        int leftMoveAnswer=dfs(right,left,right,name)+leftMove;
        if(rightMoveAnswer<leftMoveAnswer) {
        	answer+=rightMoveAnswer;
        }
        else {
        	answer+=leftMoveAnswer;
        }
        
		return answer;
	}
}