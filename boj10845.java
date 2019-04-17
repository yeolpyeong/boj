
/*
 * ť
 * https://www.acmicpc.net/problem/10845
 */

import java.util.Scanner;

class boj10845 {
	static class Queue {
		class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
				this.next = null;
			}
		}

		Node front, rear;
		int size;

		public Queue() {
			this.front = null;
			this.rear = null;
			this.size = 0;
		}

		void push(int element) {
			Node node = new Node(element);
			if (empty() == 1) {
				front = node;
				rear = node;
			} else {
				rear.next = node;
				rear = node;
			}
			size++;
		}

		int pop() {
			int element = front();
			if (empty() == 1) {
				return -1;
			} else {
				front = front.next;
				if (front == null) {
					rear = null;
				}
				size--;
			}
			return element;
		}

		int size() {
			return size;
		}

		int empty() {
			return front == null ? 1 : 0;
		}

		int front() {
			return empty() == 1 ? -1 : front.data;
		}

		int back() {
			return empty() == 1 ? -1 : rear.data;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue q = new Queue();
		while (N-- > 0) {
			String command = sc.next();
			int print = -1;
			switch (command) {
			case "push":
				int element = sc.nextInt();
				q.push(element);
				break;
			case "pop":
				print = q.pop();
				break;
			case "size":
				print = q.size();
				break;
			case "empty":
				print = q.empty();
				break;
			case "front":
				print = q.front();
				break;
			case "back":
				print = q.back();
				break;
			}
			if (!command.equals("push")) {
				System.out.println(print);
			}
		}
	}
}
