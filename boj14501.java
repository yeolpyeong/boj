/*
 * Επ»η
 * https://www.acmicpc.net/problem/14501
 */

package boj;

import java.util.Scanner;

public class boj14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		int[] DP = new int[N + 2];
		for (int i = N; i >= 1; i--) {
			int V = i + T[i] <= N + 1 ? DP[i + T[i]] + P[i] : 0;
			DP[i] = Math.max(DP[i + 1], V);
		}
		System.out.print(DP[1]);
	}
}
