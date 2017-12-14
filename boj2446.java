/*
 * 별찍기 - 9
 * https://www.acmicpc.net/problem/2446
 */

package boj;

import java.util.Scanner;

public class boj2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = 1;
		for (int i = 1; i <= 2 * N - 1; i++) {
			for (int j = 1; j <= 2 * N - n; j++) {
				System.out.print(j >= n ? '*' : ' ');
			}
			n = i < N ? n + 1 : n - 1;
			System.out.println();
		}
	}
}
