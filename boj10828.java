
/*
 * 스택
 * https://www.acmicpc.net/problem/10828
 */

import java.util.Scanner;

class boj10828 {
	static class Stack {
		class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
				this.next = null;
			}
		}

		Node top;
		int size;

		public Stack() {
			this.top = null;
			this.size = 0;
		}

		void push(int data) {
			Node node = new Node(data);
			node.next = top;
			top = node;
			size++;
		}

		int pop() {
			int data = top();
			if (empty() == 1) {
				return -1;
			} else {
				top = top.next;
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

		int top() {
			return empty() == 1 ? -1 : top.data;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack stk = new Stack();
		while (N-- > 0) {
			String command = sc.next();
			int print = -1;
			switch (command) {
			case "push":
				int data = sc.nextInt();
				stk.push(data);
				break;
			case "pop":
				print = stk.pop();
				break;
			case "size":
				print = stk.size();
				break;
			case "empty":
				print = stk.empty();
				break;
			case "top":
				print = stk.top();
				break;
			}

			if (!command.equals("push")) {
				System.out.println(print);
			}
		}
	}
}
