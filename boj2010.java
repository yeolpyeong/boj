/*
 * ÇÃ·¯±×
 * https://www.acmicpc.net/problem/2010
 */

package boj;

import java.util.Scanner;

public class boj2010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = 1;
		for (int i = 1; i <= N; i++) {
			P += sc.nextInt();
		}
		System.out.print(P - N);
	}
}
