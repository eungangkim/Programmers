class Solution {
    public int solution(String name) {
		return dfs(0,0,name.toCharArray());
	}
	public int dfs(int beforeCursor,int cursor,char []nameArr) {
		if(isDone(nameArr))return 0;
		int count=nameArr[cursor]<='N'?nameArr[cursor]-'A':91-nameArr[cursor];
		int big=Math.max(cursor, beforeCursor),small=Math.min(cursor, beforeCursor);
		count+=Math.min(big-small, small+nameArr.length-big);
		nameArr[cursor]='A';
		return count+Math.min(dfs(cursor,getNextCursor(cursor,nameArr,1),nameArr.clone()),dfs(cursor,getNextCursor(cursor,nameArr,-1),nameArr.clone()));
	}
	public int getNextCursor(int cursor,char []nameArr,int direction) {
		int count=0;
		while(count<nameArr.length&&nameArr[cursor]=='A') {
			count++;
			cursor+=direction;
			if(cursor<0) {
				cursor=nameArr.length-1;
			}
			else if(cursor>=nameArr.length) {
				cursor=0;
			}
		}
		if(count==nameArr.length)
			return 0;
		return cursor;
	}
    public boolean isDone(char []nameArr) {
		for(char c:nameArr) {
			if(c!='A')return false;
		}
		return true;
	}
}