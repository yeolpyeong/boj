/*
 * ЦђБе
 * https://www.acmicpc.net/problem/1546
 */

package boj;

import java.util.Scanner;

public class boj1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] scores = new double[N + 1];
		double M = 0;
		for (int i = 1; i <= N; i++) {
			scores[i] = sc.nextInt();
			M = Math.max(M, scores[i]);
		}
		double sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += scores[i] / M * 100;
		}
		System.out.print(String.format("%.2f", sum / N));
	}
}
