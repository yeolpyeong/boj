
/*
 * 동전 1
 * https://www.acmicpc.net/problem/2293
 */

import java.util.Scanner;

public class boj2293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}

		int[] dp = new int[k + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = 1; i <= k; i++) {
				if (i - coin >= 0) {
					dp[i] += dp[i - coin];
				}
			}
		}

		System.out.print(dp[k]);
	}
}
