class Solution {
    public int solution(int n) {
        int tempn=n;
        int first_one_bit_idx=-1,cnt=-1,beforeBitCount=0;
        int bitCount=Integer.bitCount(n);
        
        while(bitCount==Integer.bitCount(tempn)) {
        	tempn=tempn>>1;
        	first_one_bit_idx++;
        }
        beforeBitCount=Integer.bitCount(tempn)-1;
        while(tempn>=0&&beforeBitCount!=Integer.bitCount(tempn)) {
        	beforeBitCount=Integer.bitCount(tempn);
        	tempn=tempn>>1;
        	cnt++;
        }
        n+=Math.pow(2,first_one_bit_idx);
        for(int i=0;i<cnt;i++) {
        	n+=Math.pow(2,i);
        }
        return n;
    }
}