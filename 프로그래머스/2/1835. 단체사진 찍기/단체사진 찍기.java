import java.util.HashSet;
class Solution {
    char [] spot=new char[8];		//카카오프렌즈들이 서있을 8자리
	char []kakaoFriends= {'A','C','F','J','M','N','R','T'};
	HashSet<Character> candidate,selected;	//아직 서있지 않은 그룹/ 서있는 그룹 으로 나눠 분류함
    public int solution(int n, String[] data) {	
    	candidate=initSet();	//처음에는 모두 서있지 않은 그룹으로 초기화
    	selected=new HashSet<>();	
    	return dfs(0,data);
    }
    public HashSet<Character> initSet(){
    	HashSet<Character> set=new HashSet<>();
    	for(int i=0;i<8;i++) {
    		set.add(kakaoFriends[i]);
    	}
    	return set;
    }
    public int dfs(int k,String[] data) {
    	if(k==data.length) {	//모든 조건대로 줄을 섰을 경우
    		return factorial(candidate.size());	//(서있지 않은 그룹의 수)! == 현재 조건에서 나올 수 있는 경우의 수 -> 즉 서있지 않은 그룹의 프렌즈들은 어느 자리에 들어가도 무방함
    	}
    	String []condition=data[k].split("");
    	char friend1=condition[0].charAt(0),friend2=condition[2].charAt(0);	//조건을 제안한 프렌즈 / 조건을 받는 프렌즈
    	char sign=condition[3].charAt(0);	// = | > | <
    	int number=condition[4].charAt(0)-'0',cnt=0,start=0,finish=0;	// 사이 간견 크기 조건, 반환할 경우의 수, start,finish : 조건에 해당되는 프렌즈들이 모두 서있지 않은 그룹에 속할 때 조건에 맞게 자리를 찾는데 사용됨 
    	if(selected.contains(friend1)&&selected.contains(friend2)) {	// 조건에 해당되는 두 프렌즈가 이미 서있는 그룹에 속하는 경우
    		if(isRight(friend1,friend2,sign,number)) {	// 현재 서있는 위치가 이번 조건에도 부합하는 경우
    			cnt+=dfs(k+1,data);
    		}
    		return cnt;	//부합하지 않는 경우 , 0 반환
    	}
    	if(selected.contains(friend1)||selected.contains(friend2)) {	//	조건에 해당되는 두프렌즈중 하나만 서있는 그룹에 속하는 경우
    		int fixedIdx=-1;	// 서있는 그룹에 속한 프렌즈의 위치
    		char candidateFriend=0;	// 서있지 않은 그룹에 속한 프렌즈
    		
    		if(selected.contains(friend1)) {	// 조건을 제안한 프렌즈가 서있는 그룹에 속하는 경우
    			fixedIdx=indexOf(friend1);
    			candidateFriend=friend2;
    			candidate.remove(friend2);
    			selected.add(friend2);
    		}
    		else if(selected.contains(friend2)){	// 조건을 받는 프렌즈가 서있는 그룹에 속하는 경우
    			fixedIdx=indexOf(friend2);
    			candidateFriend=friend1;
    			candidate.remove(friend1);
    			selected.add(friend1);
    		}
    		for(int i=0;i<8;i++) {	//	서있지 않은 프렌즈가 모든 위치에 스며 조건 확인
    			int intervalBetween=Math.abs(fixedIdx-i)-1;	//해당 위치에 슬때 두 프렌즈 사이의 간격
    			if(spot[i]!=0&&spot[i]!='0')continue;	//해당 위치에 다른 프렌즈가 이미 서있는 경우
    			if(sign=='='&&intervalBetween==number) {
    				spot[i]=candidateFriend;
    				cnt+=dfs(k+1,data);
    				spot[i]='0';
    			}
    			else if(sign=='<'&&intervalBetween<number) {
    				spot[i]=candidateFriend;
    				cnt+=dfs(k+1,data);
    				spot[i]='0';
    			}
    			else if(sign=='>'&&intervalBetween>number) {
    				spot[i]=candidateFriend;
    				cnt+=dfs(k+1,data);
    				spot[i]='0';
    			}
    		}
            selected.remove(candidateFriend);
            candidate.add(candidateFriend);
    		return cnt;
    	}
    	if(sign=='=') {
    		start=number+1;
    		finish=number+2;
    	}
    	else if(sign=='<') {
    		start=1;
    		finish=number+1;
    	}
    	else if(sign=='>') {
    		start=number+2;
    		finish=8;
    	}
		candidate.remove(friend1);
		candidate.remove(friend2);
		selected.add(friend1);
		selected.add(friend2);
    	for(int i=0;i<8;i++) {
    		if(spot[i]!=0&&spot[i]!='0')continue;
    		for(int j=i+start;j<Math.min(8,i+finish);j++) {
    			if(spot[j]==0||spot[j]=='0') {
    	    		spot[i]=friend1;
    				spot[j]=friend2;
    				cnt+=dfs(k+1,data);
    				spot[i]=friend2;
    				spot[j]=friend1;
    				cnt+=dfs(k+1,data);
    				spot[i]='0';
    				spot[j]='0';
    			}
    		}
    	}

		candidate.add(friend1);
		candidate.add(friend2);
		selected.remove(friend1);
		selected.remove(friend2);
		return cnt;
    }
    public boolean isRight(char friend1,char friend2,char sign,int number) {
    	int idx1=indexOf(friend1),idx2=indexOf(friend2),intervalBetween=Math.abs(idx2-idx1)-1;
    	if(sign=='=')
    		return intervalBetween==number;
    	if(sign=='<')
    		return intervalBetween<number;
    	if(sign=='>')
    		return intervalBetween>number;
    	return false;
    }
    public int indexOf(char friend) {
    	for(int i=0;i<8;i++) {
    		if(friend==spot[i])return i;
    	}
    	return -1;
    }
    public int factorial(int n) {
    	int sum=1;
    	for(int i=2;i<=n;i++) {
    		sum*=i;
    	}
    	return sum;
    }
    public void show(){
        for(int i=0;i<8;i++)
            System.out.print(spot[i]+",");
        System.out.println();
    }
}