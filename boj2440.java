/*
 * º°Âï±â - 3
 * https://www.acmicpc.net/problem/2440
 */

package boj;

import java.util.Scanner;

public class boj2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = N; j >= i; j--) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
