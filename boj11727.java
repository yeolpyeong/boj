/*
 * 2*n 타일링 2
 * https://www.acmicpc.net/problem/11727
 */

package boj;

import java.util.Scanner;

public class boj11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + 2 * dp[i - 2];
			dp[i] %= 10007;
		}
		System.out.print(dp[n]);
	}
}
