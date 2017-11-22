/*
 * 이항 계수1
 * https://www.acmicpc.net/problem/11050
 */

package boj;

import java.util.Scanner;

public class boj11050 {
	static int[][] dp = new int[11][11];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		System.out.println(combination(N, K));
	}

	public static int combination(int N, int K) {
		if (K == 0 || N == K)
			return 1;
		return dp[N][K] = combination(N - 1, K - 1) + combination(N - 1, K);
	}
}
