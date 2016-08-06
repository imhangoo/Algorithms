package com.imhangoo.algorithms;

import java.util.Vector;

/**
 * Enqueue, Dequeue, find Max: all with O(1) amortized cost
 */
public class MaxQueue {
	private Vector<Integer> queue1 = new Vector<Integer>();
	private Vector<Integer> queue2 = new Vector<Integer>();
	private int front1 = 0, rear1 = 0;
	private int front2 = 0, rear2 = 0;
	
	public static void main(String[] args) {
		MaxQueue queue = new MaxQueue();
		queue.enqueue(2);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(9);
		queue.enqueue(6);
		queue.printQ1();
		queue.printQ2();
		System.out.println("Max = "+queue.max());
	}

	public void enqueue(int value) {
		// operations on queue1
		queue1.add(value);
		rear1++;
		// operations on queue2
		while (rear2 > front2 && value > queue2.get(rear2 - 1)) {
			queue2.remove(rear2 - 1);
			rear2--;
		}
		queue2.add(value);rear2++;
	}

	public void dequeue() {
		// operations on queue1
		if (rear1 <= front1)
			return;
		front1++;
		// operations on queue2
		if (queue1.get(front1 - 1) == queue2.get(front2)) {
			front2++;
		}
	}
	
	public int max() {
		return queue2.get(front2);
	}
	
	public void printQ1() {
		System.out.print("Q1: ");
		for (int i = front1; i < rear1; i++) {
			System.out.print(queue1.get(i)+" ");
		}
		System.out.println();
	}

	public void printQ2() {
		System.out.print("Q2: ");
		for (int i = front2; i < rear2; i++) {
			System.out.print(queue2.get(i)+" ");
		}
		System.out.println();

	}
	
	public void printMax(){
		System.out.println("Max = "+max());
	}

}
