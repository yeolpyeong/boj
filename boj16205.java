/*
 * 변수명
 * https://www.acmicpc.net/problem/16205
 */

package boj;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class boj16205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String variable = sc.next();

		Queue<Integer> q = new LinkedList();
		int n = 0;
		for (int i = 1; i < variable.length(); i++) {
			if (N % 2 == 0) {
				if (variable.charAt(i) == '_') {
					q.add(i - n);
					n++;
				}
			} else {
				if (Character.isUpperCase(variable.charAt(i))) {
					q.add(i);
				}
			}
		}
		q.add(100);

		variable = variable.replaceAll("_", "").toLowerCase();
		String camelCase, snake_case, PascalCase;
		camelCase = snake_case = PascalCase = variable.substring(0, 1);
		PascalCase = PascalCase.toUpperCase();
		for (int i = 1; i < variable.length(); i++) {
			if (i == q.peek()) {
				camelCase += variable.substring(i, i + 1).toUpperCase();
				snake_case += "_" + variable.charAt(i);
				PascalCase += variable.substring(i, i + 1).toUpperCase();
				q.poll();
			} else {
				camelCase += variable.charAt(i);
				snake_case += variable.charAt(i);
				PascalCase += variable.charAt(i);
			}
		}
		System.out.print(camelCase + "\n" + snake_case + "\n" + PascalCase);
	}
}
