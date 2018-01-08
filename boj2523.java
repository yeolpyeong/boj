/*
 * º°Âï±â - 13
 * https://www.acmicpc.net/problem/2523 
 */

package boj;

import java.util.Scanner;

public class boj2523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= 2 * N - 1; i++) {
			for (int j = 0; j < N - Math.abs(N - i); j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
