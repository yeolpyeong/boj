/*
 * ºÐÇØÇÕ
 * https://www.acmicpc.net/problem/2231
 */

package boj;

import java.util.Scanner;

public class boj2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int M = i, sum = i;
			while (M > 0) {
				sum += M % 10;
				M /= 10;
			}
			if (sum == N) {
				System.out.print(i);
				return;
			}
		}
		System.out.print(0);
	}
}
