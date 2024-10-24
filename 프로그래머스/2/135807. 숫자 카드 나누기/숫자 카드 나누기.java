import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
		int maxMultipleA=getMaxMultiple(arrayA);
		int maxMultipleB=getMaxMultiple(arrayB);
		int multipleA=check(arrayB,maxMultipleA);
		int multipleB=check(arrayA,maxMultipleB);
		return Math.max(multipleA, multipleB);
	}
	public int check(int []array,int maxMultiple) {
		int multiple=maxMultiple;
		while(multiple>1) {
			if(maxMultiple%multiple!=0) {
				multiple--;
				continue;
			}
			boolean flag=true;
			for(int i=0;i<array.length;i++) {
				if(array[i]%multiple==0) {
					flag=false;
					break;
				}
			}
			if(flag)break;
			multiple--;
		}
		return multiple==1?0:multiple;
	}
	public int getMaxMultiple(int []array) {
		if(array.length<2)return array[0];
		
		int maxMultiple=getMaxMultiple(array[0],array[1]);
		for(int i=2;i<array.length;i++) {
			if(array[i]%maxMultiple==0)continue;
			maxMultiple=getMaxMultiple(maxMultiple,array[i]);
			if(maxMultiple==1)return 1;
		}
		return maxMultiple;
	}
	public int getMaxMultiple(int n1,int n2) {
		int min=Math.min(n1, n2),max=Math.max(n1, n2);
		
		for(int i=min;i>=1;i--) {
			if(max%i==0&&min%i==0) {
				return i;
			}
		}
		return 1;
	}

}