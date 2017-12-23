/*
 * ÆÑÅä¸®¾ó
 * https://www.acmicpc.net/problem/10872
 */

package boj;

import java.util.Scanner;

public class boj10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int F = 1;
		for (int i = 1; i <= N; i++) {
			F *= i;
		}
		System.out.print(F);
	}
}
