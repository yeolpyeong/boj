/*
 * 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 */

package boj;

import java.util.Scanner;

public class boj10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[101][10];
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		int mod = 1000000000;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][1];
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
			dp[i][9] = dp[i - 1][8];
		}
		int sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum = (sum + dp[N][i]) % mod;
		}
		System.out.print(sum);
	}
}
