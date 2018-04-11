package defaultpackage;

import defaultpackage.MySimpleLinkedList.MyIterator;

public class Lists {
	
	public static void listElementsRepeteadInOrder( MySimpleLinkedList list1 , MySimpleLinkedList list2 , MySimpleLinkedList  listResult) {
		
		MyIterator iter1 = list1.iterator();
		MyIterator iter2 = list2.iterator();
		
		while (iter1.hasNext()) {
			
			boolean ctrl = false;
			int elemCompare = (int) iter1.next().getInfo();
			
			while ( (iter2.hasNext()) && (!ctrl) ) {
				
				int elemCompare2 = (int) iter2.next().getInfo();
				
				if (elemCompare <= elemCompare2) {
					ctrl=true;
					if ( elemCompare == elemCompare2 ) {
						System.out.print(elemCompare + "  " +  elemCompare2 + "\n");
						listResult.insertLastPosition(elemCompare);
					}						
					iter2.resetPointer();
				}
				
			}
			
			iter2.resetPointer();
			
		}
		
	}

	public static void main(String[] args) {
	
		MySimpleLinkedList list1 = new MySimpleLinkedList();
		MySimpleLinkedList list2 = new MySimpleLinkedList();
		MySimpleLinkedList listResult = new MySimpleLinkedList();
		
		list1.insertInOrder(20);
		list1.insertInOrder(10);
		list1.insertInOrder(30);
		list1.insertInOrder(25);
		list1.insertInOrder(15);
		
		list2.insertInOrder(20);
		list2.insertInOrder(75);
		list2.insertInOrder(70);
		list2.insertInOrder(25);
		list2.insertInOrder(15);
		list2.insertInOrder(100);
		
		listElementsRepeteadInOrder(list1 , list2 , listResult);
		
		
		listResult.showList();
		
		
		
	}

}
