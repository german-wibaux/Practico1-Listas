package defaultpackage;

import defaultpackage.MySimpleLinkedList.MyIterator;

public class Lists {

	public static void listElementsRepeteadInOrder(MySimpleLinkedList list1, MySimpleLinkedList list2,
			MySimpleLinkedList listResult) {
		// 5 b)
		MyIterator iter1 = list1.iterator();
		MyIterator iter2 = list2.iterator();

		while (iter1.hasNext()) {

			boolean ctrl = false;
			int elemCompare = (int) iter1.next().getInfo();

			while ((iter2.hasNext()) && (!ctrl)) {

				int elemCompare2 = (int) iter2.next().getInfo();

				if (elemCompare <= elemCompare2) {
					ctrl = true;
					if (elemCompare == elemCompare2)
						listResult.insertLastPosition(elemCompare);
					iter2.resetPointer();
				}

			}

			iter2.resetPointer();

		}
	}

	public static void listElementsRepeteadNotOrder(MySimpleLinkedList list1, MySimpleLinkedList list2,
			MySimpleLinkedList listResult) {
		// 5 a)
		MyIterator iter1 = list1.iterator();
		MyIterator iter2 = list2.iterator();

		while (iter1.hasNext()) {

			boolean ctrl = false;
			int elemCompare = (int) iter1.next().getInfo();

			while ((iter2.hasNext()) && (!ctrl)) {

				int elemCompare2 = (int) iter2.next().getInfo();

				if (elemCompare == elemCompare2) {					
					ctrl = true;
					listResult.insertInOrder(elemCompare);
				}
			}

			iter2.resetPointer();
		}
	}

	public static void main(String[] args) {

		MySimpleLinkedList list1 = new MySimpleLinkedList();
		MySimpleLinkedList list2 = new MySimpleLinkedList();
		MySimpleLinkedList listResult = new MySimpleLinkedList();

		System.out.println("////////////////////Lists in order//////////////////////////");

		list1.insertInOrder(10);
		list1.insertInOrder(15);
		list1.insertInOrder(20);
		list1.insertInOrder(25);
		list1.insertInOrder(30);
		list1.insertInOrder(100);

		list2.insertInOrder(15);
		list2.insertInOrder(20);
		list2.insertInOrder(25);
		list2.insertInOrder(70);
		list2.insertInOrder(75);
		list2.insertInOrder(100);

		listElementsRepeteadInOrder(list1, list2, listResult);

		listResult.showList();

		System.out.println("//////////////////////lists without order////////////////////////");

		MySimpleLinkedList list_1 = new MySimpleLinkedList();
		MySimpleLinkedList list_2 = new MySimpleLinkedList();
		MySimpleLinkedList list_Result = new MySimpleLinkedList();

		list_1.insert(7);
		list_1.insert(4);
		list_1.insert(3);
		list_1.insert(10);
		list_1.insert(25);
		

		list_2.insert(2);
		list_2.insert(99);
		list_2.insert(11);
		list_2.insert(10);
		list_2.insert(7);
		list_2.insert(4);
		list_2.insertInOrder(1);
		list_2.insertInOrder(100);
		list_2.insertInOrder(1000);
		list_2.insertInOrder(1005);

		listElementsRepeteadNotOrder(list_1, list_2, list_Result);

		list_Result.showList();

	}

}
