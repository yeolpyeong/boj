/*
 * ½ºÆ¼Ä¿
 * https://www.acmicpc.net/problem/9465
 */

package boj;

import java.util.Scanner;

public class boj9465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int[][] sticker = new int[2][n + 1];
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= n; j++) {
					sticker[i][j] = sc.nextInt();
				}
			}
			int[][] dp = new int[2][n + 1];
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
