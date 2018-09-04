/*
 * 경로 구하기
 * https://www.acmicpc.net/problem/11403
 */

package boj;

import java.util.Scanner;

public class boj11403 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adj[i][j] = sc.nextInt();
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (adj[i][k] * adj[k][j] == 1)
						adj[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}
}