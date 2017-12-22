/*
 * Generations of Tribbles
 * https://www.acmicpc.net/problem/9507
 */

package boj;

import java.util.Scanner;

public class boj9507 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long[] dp = new long[68];
			dp[0] = dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
			}
			System.out.println(dp[n]);
		}
	}
}
