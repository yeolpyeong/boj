/*
 * 별 찍기 - 6
 * https://www.acmicpc.net/problem/2443
 */

package boj;

import java.util.Scanner;

public class boj2443 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(' ');
			}
			for (int j = 2 * i - 1; j <= 2 * N - 1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
