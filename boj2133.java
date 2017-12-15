/*
 * 타일 채우기
 * https://www.acmicpc.net/problem/2133
 */

package boj;

import java.util.Scanner;

public class boj2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N + 1][8];
		dp[0][7] = 1;
		for (int i = 1; i <= N; i++) {
			dp[i][0] = dp[i - 1][7];
			dp[i][1] = dp[i - 1][6];
			dp[i][3] = dp[i - 1][4] + dp[i - 1][7];
			dp[i][4] = dp[i - 1][3];
			dp[i][6] = dp[i - 1][1] + dp[i - 1][7];
			dp[i][7] = dp[i - 1][0] + dp[i - 1][3] + dp[i - 1][6];
		}
		System.out.println(dp[N][7]);
	}
}
