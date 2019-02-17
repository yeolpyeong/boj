
/*
 * µ¿Àü 0
 * https://www.acmicpc.net/problem/11047
 */

import java.util.Scanner;

public class boj11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}

		int coin = N - 1;
		int count = 0;
		while (K > 0) {
			count += K / coins[coin];
			K %= coins[coin];
			coin--;
		}
		System.out.print(count);
	}
}
