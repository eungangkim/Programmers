import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    char [][]options= {{'p','c','j'},{'b','f'},{'j','s'},{'c','p'}};
	public int[] solution(String[] info, String[] query) {
		int answer[]=new int[query.length];
		Node head=initTree(info);
		
		for(int i=0;i<query.length;i++) {
			answer[i]=getNofVolunteer(head,query[i]);
		}
		
		return answer;
	}
	public int getNofVolunteer(Node head,String query) {
		int sum=0;
		String[] infos=query.split(" ");
		ArrayDeque<Node> current=new ArrayDeque<>(),next;
		current.add(head);
		for(int j=0;j<infos.length;j+=2) {
            next=new ArrayDeque<>();
			while(!current.isEmpty()) {
				current.poll().getNexts(infos[j].charAt(0),next);
			}
			current=next;
		}
		while(!current.isEmpty()) {
			sum+=current.poll().getOver(Integer.valueOf(infos[7]));
		}

		return sum;
	}
	public Node initTree(String[] info) {
		Node head=new Node(0);
		for(int i=0;i<info.length;i++) {
			String[] infos=info[i].split(" ");
			Node current=head,next=null;
			for(int j=0;j<infos.length-1;j++) {
				next=current.getNext(infos[j].charAt(0));
				current=next;
			}
			next.put(Integer.valueOf(infos[4]));
		}
		
		return head;
	}
	class Node{
		char option[];
		Node next[];
		int height;
		ArrayList<Integer> list;
		public Node(int h) {
			height=h;
			if(h==4)
				list=new ArrayList<>();
			else {
				option=options[h];
				next=new Node[option.length];
			}
		}
		public Node getNext(char c) {
			for(int i=0;i<option.length;i++) {
				if(option[i]==c) {
					if(next[i]==null) {
						next[i]=new Node(height+1);
					}
					return next[i];
				}
			}
			return null;
		}
		public void getNexts(char c,ArrayDeque<Node> next) {
			for(int i=0;i<option.length;i++) {
				if((c=='-'||c==option[i])&&this.next[i]!=null){
                    next.add(this.next[i]);
                }
			}
		}
		public void put(int num) {
			list.add(num);
		}
		public int getOver(int num) {
			if(height==4) {
				list.sort(null);
				height=-1;
            }
			for(int i=list.size()-1;i>=0;i--) {
				if(list.get(i)<num)return list.size()-i-1;
			}
			return list.size();
		}
	}
}