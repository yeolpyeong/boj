/*
 * 피보나치 수 2
 * https://www.acmicpc.net/problem/2748
 */

import java.util.Scanner;

class boj2748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] F = new long[n + 1];
		F[1] = 1;
		for (int i = 2; i <= n; i++) {
			F[i] = F[i - 1] + F[i - 2];
		}

		System.out.print(F[n]);
	}
}
