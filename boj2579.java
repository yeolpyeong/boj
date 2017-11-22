/*
 * 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */

package boj;

import java.util.Scanner;

public class boj2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] stairs = new int[n+1];
		for (int i=1; i<=n; i++) {
			stairs[i] = sc.nextInt();
		}
		
		int[][] dp = new int[n+1][3];
		for (int i=1; i<=n; i++) {
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = dp[i-1][0] + stairs[i];
			dp[i][2] = dp[i-1][1] + stairs[i];
		}
		
		System.out.print(Math.max(dp[n][1], dp[n][2]));
	}
}
