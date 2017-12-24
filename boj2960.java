/*
 * 에라토스테네스의 체
 * https://www.acmicpc.net/problem/2960
 */

package boj;

import java.util.Scanner;

public class boj2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		System.out.print(boj2960(N, K));
	}

	public static int boj2960(int N, int K) {
		int[] numbers = new int[N + 1];
		int k = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; i * j <= N; j++) {
				if (numbers[i * j] == 0) {
					k++;
					numbers[i * j] = 1;
					if (k == K) {
						return i * j;
					}
				}
			}
		}
		return 0;
	}
}
