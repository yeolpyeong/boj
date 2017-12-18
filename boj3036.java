/*
 * ¸µ
 * https://www.acmicpc.net/problem/3036 
 */

package boj;

import java.util.Scanner;

public class boj3036 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int firstRing = sc.nextInt();
		for (int i = 2; i <= N; i++) {
			int nextRing = sc.nextInt();
			int gcd = gcd(firstRing, nextRing);
			System.out.println(firstRing / gcd + "/" + nextRing / gcd);
		}
	}

	public static int gcd(int n, int m) {
		return m != 0 ? gcd(m, n % m) : n;
	}
}
