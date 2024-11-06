class Solution {
    public int[] solution(String[][] places) {
    	int answer[]=new int[5];
    	for(int k=0;k<5;k++) {
    		answer[k]=1;
    		for(int i=0;i<5;i++) {
    			for(int j=0;j<5;j++) {
    				if(places[k][i].charAt(j)=='P'&&!isDistancing(places[k],i,j)) {
    					answer[k]=0;
    					break;
    				}
    			}
    			if(answer[k]==0)break;
    		}
    	}
    	return answer;
    }
    public boolean isDistancing(String[] place,int i,int j) {
    	int dr[]= {-1,0,1,0};
    	int dc[]= {0,1,0,-1};
    	for(int k=0;k<4;k++) {
    		int nexti=i+dr[k];
    		int nextj=j+dc[k];
    		if(0<=nexti&&nexti<5&&0<=nextj&&nextj<5) {
    			char c=place[nexti].charAt(nextj);
    			if(c=='P') {
    				return false;
    			}
    			else if(c=='O') {
    				for(int x=k+3;x<k+6;x++) {
    					int nexti2=nexti+dr[x%4];
    					int nextj2=nextj+dc[x%4];
    					if(0<=nexti2&&nexti2<5&&0<=nextj2&&nextj2<5&&place[nexti2].charAt(nextj2)=='P') {
    						return false;
    					}
    				}
    			}
    		}
    	}
    	return true;
    }
}