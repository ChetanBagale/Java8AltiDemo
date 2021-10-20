package demo.immutable;

import java.util.Scanner;

class SinglyLinkList {
	int data;
	SinglyLinkList next;

	public SinglyLinkList() {
		// TODO Auto-generated constructor stub
	}
}

public class BinaryToDecimal {

	public static SinglyLinkList list = null;;

	public static void insert(int data) {
		if (list == null) {
			list = new SinglyLinkList();
			list.data = data;
			list.next = null;
		} else {
			SinglyLinkList temp = list;
			while (temp.next != null)
				temp = temp.next;
			temp.next = new SinglyLinkList();
			temp.next.data = data;
			temp.next.next = null;

		}
	}

	public static void addToPosition(int position, int data) {

		SinglyLinkList temp = list;

		if (position == 0) {
			temp = new SinglyLinkList();
			temp.next = list;
			temp.data = data;

			list = temp;
		} else {
			int count = 0;
			while ((position - 1) != count) {
				temp = temp.next;
				count++;
			}
			SinglyLinkList prevNext = temp.next;

			temp.next = new SinglyLinkList();
			temp.next.data = data;
			temp.next.next = prevNext;

		}

	}

	public static void reverse() {
		SinglyLinkList p, q, r;
		p = null;
		q = list;
		r = q.next;
		while (q != null) {
			q.next = p;
			p = q;
			q = r;
			if (q != null)
				r = q.next;
		}

		list = p;

	}

	public static void display() {
		SinglyLinkList temp = list;
		System.out.println("Binary Linked List:");
		while (temp != null) {
			System.out.print(" " + temp.data);
			temp = temp.next;
		}
		System.out.println();
	}

	public static long decimal() {
		long decimalNum = 0;
		int count = 0;
		SinglyLinkList temp = list;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		temp = list;

		while (temp != null) {
			count--;
			decimalNum = decimalNum + temp.data * (long) Math.pow(2, count);
			temp = temp.next;
		}

		return decimalNum;
	}

	public static void main(String[] args) {

		int ch = 0;

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Enter binary number");
			insert(scanner.nextInt());
			System.out.println("Do you want to continue(1/0)");
			ch = scanner.nextInt();
		} while (ch == 1);

		display();
		reverse();
		display();
		reverse();
		display();
//		System.out.println("Decimal number is:"+decimal());
		/*
		 * addToPosition(0, 3); addToPosition(4, 5); addToPosition(2, 6); display();
		 * 
		 */

	}

}
