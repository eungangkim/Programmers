class Solution {
    public long[] solution(long[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			String binaryS="0"+Long.toBinaryString(numbers[i]);
			int lastZeroIndex=binaryS.lastIndexOf('0');
			if(lastZeroIndex==binaryS.length()-1) {
				binaryS=binaryS.substring(0,binaryS.length()-1)+"1";
			}
			else {
				binaryS=binaryS.substring(0,lastZeroIndex)+"10"+binaryS.substring(lastZeroIndex+2,binaryS.length());
			}
			numbers[i]=Long.parseLong(binaryS,2);
		}
		return numbers;
	}
}