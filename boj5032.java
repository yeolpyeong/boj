/*
 * Åº»ê À½·á
 * https://www.acmicpc.net/problem/5032
 */

package boj;

import java.util.Scanner;

public class boj5032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int f = sc.nextInt();
		int c = sc.nextInt();
		int m = 0;
		while (true) {
			if (e + f < c)
				break;

			int n = e + f;
			m += n / c;
			e = n % c;
			f = n / c;
		}
		System.out.print(m);
	}
}
