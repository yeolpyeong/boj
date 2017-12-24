/*
 * ¾Ç¼ö
 * https://www.acmicpc.net/problem/8394
 */

package boj;

import java.util.Scanner;

public class boj8394 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10;
		}
		System.out.print(dp[N]);
	}
}
