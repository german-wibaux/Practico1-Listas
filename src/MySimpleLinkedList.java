//import listaRepetidos.Nodo;

public class MySimpleLinkedList {
	
	protected Node first;
	
	public MySimpleLinkedList() {
		first = null;
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
	
//	public boolean search(Node searching, Object element) {
//		if (searching == null) 
//			return false;
//		if (element.equals(searching.getInfo())) 
//			return true;
//		return search(searching.getNext(), element); 
//	}
	
	public void showList() {
		Node print = this.first;
		while (print != null) {
			System.out.print(print.getInfo() + "\n");
			print = print.getNext();
		}
		
	}
	
//	public Node getRoot() {
//		return this.first;
//	}
	
	public Object showFirst() {
		if (this.first==null) return -1;
		else return this.first.getInfo();	
	}
	
//	public void print(int n) {
//		
//		Node showInfo = this.first;
//		int count=0;
//		
//		if (tamanio()>=n) {
//			while (contador!=n) {
//				contador++;
//				if (count==n) {
//					System.out.println(showInfo.getInfo());
//				}
//				showInfo=showInfo.getNext();
//			}
//			System.out.println(showInfo.getInfo());
//		}
//		else System.out.println("The list is empty");
//	}
	
//	
	public boolean isEmpty() {
		return this.first == null;
	}
//	
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
	
}
