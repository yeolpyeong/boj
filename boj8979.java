/*
 * 올림픽
 * https://www.acmicpc.net/problem/8979
 */

package boj;

import java.util.Scanner;

public class boj8979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] medal = new int[N + 1][4];
		long[] score = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			medal[i][0] = sc.nextInt();
			medal[i][1] = sc.nextInt();
			medal[i][2] = sc.nextInt();
			medal[i][3] = sc.nextInt();
			score[i] = medal[i][1] * Long.parseLong("1000000000000") + medal[i][2] * Long.parseLong("1000000")
					+ medal[i][3];
		}

		int rank = 1;
		for (int i = 1; i <= N; i++) {
			if (medal[i][0] == K) {
				for (int j = 1; j <= N; j++) {
					if (score[i] < score[j]) {
						rank++;
					}
				}
				break;
			}
		}
		System.out.print(rank);
	}
}
