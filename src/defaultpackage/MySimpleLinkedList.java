package defaultpackage;

import java.util.Iterator;

public class MySimpleLinkedList implements Iterable<Object> {

	private Node first;
	private int size;

	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}

	public class MyIterator implements Iterator<Object> {
		// Create iterator to go through lists

		private Node pointer;

		private MyIterator(Node first) {
			pointer = first;
		}

		// Implement iterator methods
		public boolean hasNext() {
			return pointer != null;
		}

		public Node next() {
			// Return the next element
			Node tmp = pointer;
			pointer = pointer.getNext();
			return tmp;
		}

		public void resetPointer() {
			// Reset iterator
			pointer = first;
		}
	}

	public void insertInOrder(Object toInsertValue) {
		// Insert elements in order
		int toInsert = (int) toInsertValue;

		if ((this.isEmpty()) || (toInsert <= (int) this.first.getInfo())) {
			this.insert(toInsertValue);
		} else {

			MyIterator iter = this.iterator();
			boolean ctrl = false;

			while ((iter.hasNext()) && (!ctrl)) {

				Node beginning = iter.next();
				Node tmp = beginning;

				if (beginning.getNext() != null) {
					tmp = tmp.getNext();
				}

				if (toInsert < (int) tmp.getInfo()) {
					ctrl = true;
					beginning.setNext(new Node(toInsertValue, tmp));
				}

			}

			if (!ctrl) {
				this.insertLastPosition(toInsertValue);
			}

		}

	}

	public void insert(Object o) {
		// Insert at the beginning
		Node tmp = new Node(o, null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}

	public void insertLastPosition(Object o) {
		// Insert at the end

		if (this.isEmpty())
			this.insert(o);
		else {

			Node tmp = new Node(o, null);
			Node last = this.first;

			for (int i = 0; i < this.size - 1; i++) {
				last = last.getNext();
			}
			last.setNext(tmp);
			this.size++;

		}

	}

	public void showList() {
		// Print content of list
		Node print = this.first;
		if (print == null)
			System.out.println("The list is empty");
		else {
			while (print != null) {
				System.out.print("\\-> " + print.getInfo() + "\n");
				print = print.getNext();
			}
		}

	}

	public Object extract() {
		// Extract the first element of the list
		Node tmp = this.first;
		this.first = tmp.getNext();
		this.size--;
		return tmp.getInfo();
	}

	public boolean isEmpty() {
		// Returns true if list is empty
		return this.first == null;
	}

	public int getSize() {
		// Returns size of the list
		return this.size;
	}

	public Object getFirst() {
		// Returns the info of the first element
		if (this.first == null)
			return -1;
		else
			return this.first.getInfo();
	}

	public MyIterator iterator() {
		return new MyIterator(this.first);
	}

}
