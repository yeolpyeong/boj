/*
 * ÀÌÄ£¼ö
 * https://www.acmicpc.net/problem/2193
 */

package boj;

import java.util.Scanner;

public class boj2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[91];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.print(dp[N]);
	}
}
