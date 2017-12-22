/*
 * 파도반 수열
 * https://www.acmicpc.net/problem/9461
 */

package boj;

import java.util.Scanner;

public class boj9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			long[] dp = new long[101];
			dp[1] = dp[2] = dp[3] = 1;
			dp[4] = dp[5] = 2;
			for (int i = 6; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 5];
			}
			System.out.println(dp[N]);
		}
	}
}
