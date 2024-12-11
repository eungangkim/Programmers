class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
		StringBuilder sb=new StringBuilder();
		int min=Math.abs(x-r)+Math.abs(y-c),repeat=k-min;
		if(repeat<0||repeat%2!=0)return "impossible";
		
		while(min!=k) {
			if(x!=n) {
				sb.append('d');
				x++;
			}
			else if(y!=1) {
				sb.append('l');
				y--;
			}
			else if(y!=m) {
				sb.append('r');
				y++;
			}
			else if(x!=1) {
				sb.append('u');
				x--;
			}
			min=Math.abs(x-r)+Math.abs(y-c);
			k--;
            //System.out.println("min:"+min+" k:"+k+" sb:"+sb.toString());
		}
        
		for(int i=0;i<k;i++) {
			if(x<r) {
				sb.append('d');
				x++;
			}
			else if(y>c) {
				sb.append('l');
				y--;
			}
			else if(y<c) {
				sb.append('r');
				y++;
			}
			else if(x>r) {
				sb.append('u');
				x--;
			}
            else if(x<=r&&x!=n) {
				sb.append('d');
				x++;
			}
			else if(y>=c&&y!=1) {
				sb.append('l');
				y--;
			}
			else if(y<=c&&y!=m) {
				sb.append('r');
				y++;
			}
			else if(x>=r&&x!=1) {
				sb.append('u');
				x--;
			}
            //System.out.println("x:"+x+" y:"+y+" sb:"+sb.toString());
		}
		return sb.toString();	
	}
}