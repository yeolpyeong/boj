/*
 * 순열 사이클
 * https://www.acmicpc.net/problem/10451
 */

package boj;

import java.util.Scanner;

public class boj10451 {
	static int[] adj, check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			adj = new int[N + 1];
			check = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = sc.nextInt();
			}

			int C = 0;
			for (int i = 1; i <= N; i++) {
				if (check[i] != 1) {
					solution(i);
					C++;
				}
			}
			System.out.println(C);
		}

	}

	public static void solution(int n) {
		if (check[n] == 1)
			return;
		
		check[n] = 1;
		solution(adj[n]);
	}
}
