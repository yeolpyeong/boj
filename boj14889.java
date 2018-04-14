/*
 * 스타트와 링크
 * https://www.acmicpc.net/problem/14889
 */

package boj;

import java.util.Scanner;

public class boj14889 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				S[i][j] = sc.nextInt();
			}
		}

		boj14889(0, 1, new int[N + 1]);
		System.out.print(min);
	}

	public static void boj14889(int n, int m, int[] g) {
		if (n == N / 2) {
			min = Math.min(min, scoring(g));
			return;
		}

		for (int i = m; i <= N; i++) {
			if (g[i] == 0) {
				g[i]++;
				boj14889(n + 1, i, g);
				g[i]--;
			}
		}
	}

	public static int scoring(int[] g) {
		int s1 = 0, s2 = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (g[i] + g[j] == 0) {
					s1 += S[i][j] + S[j][i];
				}
				if (g[i] + g[j] == 2) {
					s2 += S[i][j] + S[j][i];
				}
			}
		}
		return (int) Math.abs(s1 - s2);
	}
}
