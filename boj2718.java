/*
 * 타일 채우기
 * https://www.acmicpc.net/problem/2718
 */

package boj;

import java.util.Scanner;

public class boj2718 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int[][] dp = new int[N + 1][16];
			dp[0][15] = 1;
			for (int i = 1; i <= N; i++) {
				dp[i][0] = dp[i - 1][15];
				dp[i][1] = dp[i - 1][14];
				dp[i][2] = dp[i - 1][13];
				dp[i][3] = dp[i - 1][12];
				dp[i][4] = dp[i - 1][11];
				dp[i][5] = dp[i - 1][10] + dp[i - 1][15];
				dp[i][6] = dp[i - 1][9];
				dp[i][7] = dp[i - 1][8];
				dp[i][8] = (dp[i - 1][7] + dp[i - 1][15]);
				dp[i][9] = dp[i - 1][6];
				dp[i][10] = (dp[i - 1][5] + dp[i - 1][15]);
				dp[i][11] = (dp[i - 1][4] + dp[i - 1][12] + dp[i - 1][14]);
				dp[i][12] = (dp[i - 1][3] + dp[i - 1][11]);
				dp[i][13] = (dp[i - 1][2] + dp[i - 1][14]);
				dp[i][14] = (dp[i - 1][1] + dp[i - 1][11] + dp[i - 1][13]);
				dp[i][15] = (dp[i - 1][0] + dp[i - 1][5] + dp[i - 1][8] + dp[i - 1][10] + dp[i - 1][15]);
			}
			System.out.println(dp[N][15]);
		}
	}
}
