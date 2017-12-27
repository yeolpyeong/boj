/*
 * 절사평균
 * https://www.acmicpc.net/problem/6986
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj6986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		double[] score = new double[N];
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextDouble();
		}

		Arrays.sort(score);
		double sum1, sum2;
		sum1 = sum2 = 0;
		for (int i = 0; i < N; i++) {
			if (i < K) {
				score[i] = score[K];
			} else if (i > N - (K + 1)) {
				score[i] = score[N - (K + 1)];
			} else {
				sum1 += score[i];
			}
			sum2 += score[i];
		}
		System.out.format("%.2f\n%.2f", sum1 / (N - 2 * K), sum2 / N);
	}
}
