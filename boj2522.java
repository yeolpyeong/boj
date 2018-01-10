/*
 * º°Âï±â - 12
 * https://www.acmicpc.net/problem/2522
 */

package boj;

import java.util.Scanner;

public class boj2522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= 2 * N - 1; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(Math.abs(N - i) < j ? '*' : ' ');
			}
			System.out.println();
		}
	}
}
