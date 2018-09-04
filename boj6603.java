/*
 * ·Î¶Ç
 * https://www.acmicpc.net/problem/6603	
 */

package boj;

import java.util.Scanner;
import java.util.Stack;

public class boj6603 {
	static int k;
	static int[] S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			k = sc.nextInt();
			if (k == 0)
				break;

			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = sc.nextInt();
			}

			Stack<Integer> res = new Stack<>();
			dfs(res, 0);
			System.out.println();
		}
	}

	public static void dfs(Stack<Integer> res, int n) {
		if (res.size() == 6) {
			for (int i : res) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		if (n == k)
			return;

		res.push(S[n]);
		dfs(res, n + 1);
		res.pop();
		dfs(res, n + 1);
	}
}
