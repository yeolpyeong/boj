/*
 * 평균은 넘겠지
 * https://www.acmicpc.net/problem/4344
 */

package boj;

import java.util.Scanner;

public class boj4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		while (C-- > 0) {
			int N = sc.nextInt();
			int[] scores = new int[N + 1];
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				scores[i] = sc.nextInt();
				sum += scores[i];
			}
			int mean = sum / N;

			int n = 0;
			for (int i = 1; i <= N; i++) {
				if (scores[i] > mean)
					n++;
			}
			System.out.println(String.format("%.3f", (double) n / N * 100) + "%");
		}
	}
}
