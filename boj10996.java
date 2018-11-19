/*
 * 별 찍기 - 21
 * https://www.acmicpc.net/problem/10996
 */

package boj;

import java.util.Scanner;

public class boj10996 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= 2 * N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print((i + j) % 2 == 0 ? '*' : ' ');
			}
			System.out.println();
		}
	}
}
