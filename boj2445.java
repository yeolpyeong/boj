/*
 * º°Âï±â - 8
 * https://www.acmicpc.net/problem/2445
 */

package boj;

import java.util.Scanner;

public class boj2445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = 1;
		for (int i = 1; i <= 2 * N - 1; i++) {
			for (int j = 1; j <= 2 * N; j++) {
				System.out.print(j <= n || j >= 2 * N - n + 1 ? '*' : ' ');
			}
			n = i < N ? n + 1 : n - 1;
			System.out.println();
		}
	}
}
