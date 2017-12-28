/*
 * LCM
 * https://www.acmicpc.net/problem/5347
 */

package boj;

import java.util.Scanner;

public class boj5347 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println((long) a * b / gcd(a, b));
		}
	}

	public static int gcd(int a, int b) {
		return b != 0 ? gcd(b, a % b) : a;
	}
}
