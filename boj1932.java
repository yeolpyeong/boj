/*
 * 숫자삼각형
 * https://www.acmicpc.net/problem/1932
 */

package boj;

import java.util.Scanner;

public class boj1932 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				int size = sc.nextInt();
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + size;
			}
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dp[n][i]);
		}
		System.out.print(max);
	}
}
