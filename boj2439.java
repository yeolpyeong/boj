/*
 * 별찍기 - 2
 * https://www.acmicpc.net/problem/2439
 */

package boj;

import java.util.Scanner;

public class boj2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(j <= N - i ? ' ' : '*');
			}
			System.out.println();
		}
	}
}
