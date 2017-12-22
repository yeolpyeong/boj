/*
 * 이동하기
 * https://www.acmicpc.net/problem/11048
 */

package boj;

import java.util.Scanner;

public class boj11048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] maze = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				maze[i][j] = sc.nextInt();
				dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + maze[i][j];
			}
		}
		System.out.print(dp[N][M]);
	}
}
