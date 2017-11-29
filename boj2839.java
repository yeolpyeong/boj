/*
 * º≥≈¡ πË¥ﬁ 
 * https://www.acmicpc.net/problem/2839
 */

package boj;

import java.util.Scanner;

public class boj2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[5001];
		for (int i = 0; i <= N; i++) {
			dp[i] = 4444;
		}
		dp[3] = 1;
		dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
		}
		System.out.print(dp[N] < 4444 ? dp[N] : -1);
	}
}
