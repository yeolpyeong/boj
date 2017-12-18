/*
 * 최대공약수와 최소공배수
 * https://www.acmicpc.net/problem/2609
 */

package boj;

import java.util.Scanner;

public class boj2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.print(gcd(n, m) + "\n" + n * m / gcd(n, m));
	}

	public static int gcd(int n, int m) {
		return m != 0 ? gcd(m, n % m) : n;
	}
}
