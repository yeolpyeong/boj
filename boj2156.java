/*
 * 포도주 시식
 * https://www.acmicpc.net/problem/2156
 */

package boj;

import java.util.Scanner;

public class boj2156 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wine = new int[n + 1];
		int[][] dp = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			wine[i] = sc.nextInt();
			dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
			dp[i][1] = dp[i - 1][0] + wine[i];
			dp[i][2] = dp[i - 1][1] + wine[i];
		}

		System.out.print(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
	}
}
