/*
 * 벌집
 * https://www.acmicpc.net/problem/2292
 */

package boj;

import java.util.Scanner;

public class boj2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = 1;
		while (N > 1) {
			N -= 6 * C;
			C++;
		}
		System.out.print(C);
	}
}
