/*
 * 2차원 배열의 합
 * https://www.acmicpc.net/problem/2167
 */

package boj;

import java.util.Scanner;

public class boj2167 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] matrix = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				matrix[i][j] = sc.nextInt();
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
			}
		}
		int K = sc.nextInt();
		while (K-- > 0) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i - 1][j - 1]);
		}
	}
}
