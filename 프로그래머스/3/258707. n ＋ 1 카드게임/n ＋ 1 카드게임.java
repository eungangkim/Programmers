class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int target=cards.length+1;
        boolean []picked=new boolean[cards.length+1];
        boolean []discarded=new boolean[cards.length+1];
        for(int i=0;i<cards.length/3;i++) {
        	picked[cards[i]]=true;
        }
        
        for(int i=cards.length/3;i<cards.length;i+=2) {
        	if(picked[target-cards[i]]&&coin>0) {
        		coin--;
        		picked[cards[i]]=true;
        	}
        	
        	else {
        		discarded[cards[i]]=true;
        	}
        	if(picked[target-cards[i+1]]&&coin>0) {
        		coin--;
        		picked[cards[i+1]]=true;
        	}
        	else {
        		discarded[cards[i+1]]=true;
        	}
        	//show(answer,picked);
            //show(answer,discarded);
        	if(!useCard(picked)) {
        		if(!(coin>1&&useCard(discarded))) {
        			return answer;
        		}
        		else {
        			coin-=2;
        		}
        	}
        	answer++;
        }
        
        return answer;
    }
	public boolean useCard(boolean []picked) {
		for(int i=1;i<=picked.length/2;i++) {
			if(picked[i]&&picked[picked.length-i]) {
				picked[i]=false;
				picked[picked.length-i]=false;
				return true;
			}
		}
		return false;
	}
	public void show(int i,boolean []picked) {
		System.out.println(i+"라운드--");
		
		for(int j=1;j<picked.length;j++) {
			if(picked[j]) {
				System.out.print(j+"  ");
			}
		}
		System.out.println();
	}
}