/*
 * 다리 놓기
 * https://www.acmicpc.net/problem/1010
 */

package boj;

import java.util.Scanner;

public class boj1010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] dp = new int[N + 1][M + 1];
			for (int i = 0; i <= N; i++) {
				for (int j = i; j <= M; j++) {
					dp[i][j] = i == 0 ? 1 : dp[i - 1][j - 1] + dp[i][j - 1];
				}
			}
			System.out.println(dp[N][M]);
		}
	}
}
