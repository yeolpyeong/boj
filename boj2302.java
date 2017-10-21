/*
 * 극장 좌석
 * https://www.acmicpc.net/problem/2302
 */

package boj;

import java.util.Scanner;

public class boj2302 {
	static int[] d = new int[42];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int nCase = 1;
		int[] fixedSeat = new int[N + 2];

		for (int i = 1; i <= M; i++) {
			fixedSeat[i] = sc.nextInt();
		}
		fixedSeat[M + 1] = N + 1;

		for (int i = 0; i <= M; i++) {
			nCase *= fivonacci(fixedSeat[i + 1] - fixedSeat[i]);
		}
		System.out.println(nCase);
	}

	public static int fivonacci(int N) {
		if (d[N] != 0)
			return d[N];

		if (N == 1 || N == 2)
			return 1;
		else
			return d[N] = fivonacci(N - 2) + fivonacci(N - 1);
	}
}
