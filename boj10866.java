
/*
 * 덱
 * https://www.acmicpc.net/problem/10866
 */

import java.util.Scanner;

class boj10866 {
	static class Deque {
		class Node {
			int data;
			Node prev, next;

			public Node(int data) {
				this.data = data;
				this.prev = null;
				this.next = null;
			}
		}

		Node front, rear;
		int size;

		public Deque() {
			this.front = null;
			this.rear = null;
			this.size = 0;
		}

		void push_front(int data) {
			Node node = new Node(data);
			if (empty() == 1) {
				front = node;
				rear = node;
			} else {
				front.prev = node;
				node.next = front;
				front = node;
			}
			size++;
		}

		void push_back(int data) {
			Node node = new Node(data);
			if (empty() == 1) {
				front = node;
				rear = node;
			} else {
				node.prev = rear;
				rear.next = node;
				rear = node;
			}
			size++;
		}

		int pop_front() {
			int data = front();
			if (empty() == 1) {
				return -1;
			} else {
				front = front.next;
				size--;
			}
			return data;
		}

		int pop_back() {
			int data = back();
			if (empty() == 1) {
				return -1;
			} else {
				rear = rear.prev;
				size--;
			}
			return data;
		}

		int size() {
			return size;
		}

		int empty() {
			return size == 0 ? 1 : 0;
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
		Deque dq = new Deque();
		while (N-- > 0) {
			String command = sc.next();
			int data, print = -1;
			switch (command) {
			case "push_front":
				data = sc.nextInt();
				dq.push_front(data);
				break;
			case "push_back":
				data = sc.nextInt();
				dq.push_back(data);
				break;
			case "pop_front":
				print = dq.pop_front();
				break;
			case "pop_back":
				print = dq.pop_back();
				break;
			case "size":
				print = dq.size();
				break;
			case "empty":
				print = dq.empty();
				break;
			case "front":
				print = dq.front();
				break;
			case "back":
				print = dq.back();
				break;
			}

			if (!(command.equals("push_front") || command.equals("push_back"))) {
				System.out.println(print);
			}
		}
	}
}
