/*
 * 수학적 호기심
 * https://www.acmicpc.net/problem/9094
 */

package boj;

import java.util.Scanner;

public class boj9094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int c = 0;
			for (int a = 1; a < n - 1; a++) {
				for (int b = a + 1; b < n; b++) {
					double exp = (double) (a * a + b * b + m) / (a * b);
					if (exp == Math.ceil(exp))
						c++;
				}
			}
			System.out.println(c);
		}
	}
}
