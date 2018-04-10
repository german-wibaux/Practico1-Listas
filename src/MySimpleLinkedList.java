
import java.util.Iterator;



public class MySimpleLinkedList implements Iterable<Object> {
	//Create iterator to go through lists
	
	private Node first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}	
	
	public class MyIterator implements Iterator<Object>{
		
		private Node pointer;
		
		private MyIterator(Node first){
			pointer=first;
		}
		
		//Implement iterator methods		
		public boolean hasNext() {
			return pointer!=null;
		}
	
		public Node next() {
			Node tmp=pointer;
			pointer=pointer.getNext();
			return tmp;
		}
		
		//Reset iterator
		public void resetCursor() {
			pointer=first;
		}
	}
	
	public void insert(Object o) {
		Node tmp = new Node(o, null);
		tmp.setNext(first);
		first = tmp;
	}
	
	public void insertLastPosition(Object o) {
		Node tmp = new Node(o ,null);
		Node last = this.first;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.setNext(tmp);
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void showList() {
		Node print = this.first;
		while (print != null) {
			System.out.print(print.getInfo() + "\n");
			print = print.getNext();
		}		
	}
	
	public Object showFirst() {
		if (this.first==null) return -1;
		else return this.first.getInfo();	
	}
	
	
	public boolean isEmpty() {
		return this.first == null;
	}

	public int size() {
		Node run = this.first;
		int count = 0;
		
		if (run != null) {
			System.out.println(run.getInfo());
			run = run.getNext();
			count ++;
		}
		
		return count;
		
	}
	
	public MyIterator iterator() {
		return new MyIterator(this.first);
	}
	
}
