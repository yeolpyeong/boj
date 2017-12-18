/*
 * 소수 구하기
 * https://www.acmicpc.net/problem/1929
 */

package boj;

import java.util.Scanner;

public class boj1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		for (int i = M; i <= N; i++) {
			if (isPrime(i))
				System.out.println(i);
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
