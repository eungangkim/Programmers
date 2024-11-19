import java.util.ArrayDeque;

class Solution {
	char [][] symbols = {
			{'+','-','*'},
			{'+','*','-'},
			{'-','+','*'},
			{'-','*','+'},
			{'*','+','-'},
			{'*','-','+'}};
	public long solution(String expression) {
		long answer=0;
		ArrayDeque<Character> symbolQueue=new ArrayDeque<>();
		ArrayDeque<Long> operandQueue=new ArrayDeque<>();
		initQueue(expression,symbolQueue,operandQueue);
		
		for(int i=0;i<6;i++) {
			answer=Math.max(answer,Math.abs(getValue(symbolQueue.clone(),operandQueue.clone(),i)));
		}
		return answer;
	}
	public void initQueue(String expression,ArrayDeque<Character> symbolQueue,ArrayDeque<Long> operandQueue) {
		int start=0;
		for(int i=0;i<expression.length();i++) {
			char c=expression.charAt(i);
			if(c<'0'||c>'9') {
				symbolQueue.add(c);
				operandQueue.add(Long.valueOf(expression.substring(start, i)));
				start=i+1;
			}
		}
		operandQueue.add(Long.valueOf(expression.substring(start, expression.length())));
	}
	public long getValue(ArrayDeque<Character> symbolQueue,ArrayDeque<Long> operandQueue,int k) {
		for(int i=0;i<3;i++) {
			ArrayDeque<Character> nextSymbol=new ArrayDeque<>();
			ArrayDeque<Long> nextOperand=new ArrayDeque<>();
			long beforeInt=operandQueue.poll();
			long nextInt=0;
			while(!symbolQueue.isEmpty()) {
				char symbol=symbolQueue.poll();
				nextInt=operandQueue.poll();
				if(symbol==symbols[k][i]) {
					long result=getValueOfSimpleFormula(beforeInt,nextInt,symbol);
					beforeInt=result;
				}
				else {
					nextSymbol.add(symbol);
					nextOperand.add(beforeInt);
                    beforeInt=nextInt;
				}
			}
			nextOperand.add(beforeInt);
			
			symbolQueue=nextSymbol;
			operandQueue=nextOperand;
		}
		return operandQueue.poll();
	}
	public long getValueOfSimpleFormula(long beforeInt,long nextInt,char symbol) {
		switch(symbol) {
		case '+':
			return beforeInt+nextInt;
		case '-':
			return beforeInt-nextInt;
		case '*':
			return beforeInt*nextInt;
		default:
			return 0;
		}
	}
}