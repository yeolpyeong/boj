/*
 * 크리스마스 파티
 * https://www.acmicpc.net/problem/10708
 */

package boj;

import java.util.Scanner;

public class boj10708 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			A[i] = sc.nextInt();
		}

		int[] score = new int[N + 1];
		for (int i = 1; i <= M; i++) {
			int count = 0;
			for (int j = 1; j <= N; j++) {
				int B = sc.nextInt();
				if (B == A[i]) {
					score[j]++;
					count++;
				}
			}
			score[A[i]] += N - count;
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(score[i]);
		}
	}
}
