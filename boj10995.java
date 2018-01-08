/*
 * 별찍기 - 20
 * https://www.acmicpc.net/problem/10995
 */

package boj;

import java.util.Scanner;

public class boj10995 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(i % 2 == 0 ? " *" : "* ");
			}
			System.out.println();
		}
	}
}
