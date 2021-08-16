/*
 * 균형잡힌 세상
 * https://www.acmicpc.net/problem/4949
 */

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4949 {
	static void isItBalanced(String string) {
		Stack<Character> stack = new Stack<>();
		boolean balanced = true;
		
		for (char c : string.toCharArray()) {
			if (c == '(' || c == '[') {
				stack.push(c);
			}

			if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					balanced = false;
					break;
				}
			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					balanced = false;
					break;
				}
			}
		}

		if (!stack.isEmpty()) {
			balanced = false;
		}

		System.out.println(balanced ? "yes" : "no");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String string = br.readLine();
			if (string.equals(".")) {
				break;
			}
			
			isItBalanced(string);
		}
	}
}
