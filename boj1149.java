/*
 * RGB거리
 * https://www.acmicpc.net/problem/1149
 */

package boj;

import java.util.Scanner;

public class boj1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] rgb = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
			}
		}
		System.out.print(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}
