/*
 * 별 찍기 - 15
 * https://www.acmicpc.net/problem/10990
 */

package boj;

import java.util.Scanner;

public class boj10990 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N + i - 1; j++) {
				System.out.print(j == N - i + 1 || j == N + i - 1 ? '*' : ' ');
			}
			System.out.println();
		}
	}
}
