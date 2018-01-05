/*
 * ÆøÁ×¼î
 * https://www.acmicpc.net/problem/1773
 */

package boj;

import java.util.Scanner;

public class boj1773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] T = new int[C + 1];
		int n = 0;
		for (int i = 1; i <= N; i++) {
			int P = sc.nextInt();
			for (int j = 1; j <= C / P; j++) {
				if (T[P * j] == 0)
					T[P * j] = ++n;
			}
		}
		System.out.print(n);
	}
}
