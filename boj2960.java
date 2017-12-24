/*
 * 에라토스테네스의 체
 * https://www.acmicpc.net/problem/2960
 */

package boj;

import java.util.Scanner;

public class boj2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] numbers = new int[N + 1];
		int k = 0;
		for (int i = 2; i <= N; i++) {
			if (isPrime(i)) {
				for (int j = 1; i * j <= N; j++) {
					if (numbers[i * j] == 0) {
						k++;
						numbers[i * j] = 1;
						if (k == K) {
							System.out.print(i * j);
							return;
						}
					}
				}
			}
		}
	}

	public static boolean isPrime(int n) {
		if (n == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
