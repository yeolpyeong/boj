/*
 * 오르막 수
 * https://www.acmicpc.net/problem/11057
 */

package boj;

import java.util.Scanner;

public class boj11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[1001][10];
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = i + 1;
		}
		int mod = 10007;
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				dp[i][j] = j == 0 ? 1 : (dp[i - 1][j] + dp[i][j - 1]) % mod;
			}
		}
		System.out.print(dp[N][9]);
	}
}
