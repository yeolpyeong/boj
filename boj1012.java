/*
 * 유기농 배추
 * https://www.acmicpc.net/problem/1012
 */

package boj;

import java.util.Scanner;

public class boj1012 {
	static int M, N, nEarthworm;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			map = new int[M][N];

			while (K-- > 0) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}

			nEarthworm = 0;
			boj1012();
			System.out.println(nEarthworm);
		}
	}

	public static void boj1012() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					checkSizeOfField(i, j);
					nEarthworm++;
				}
			}
		}
	}

	public static void checkSizeOfField(int x, int y) {
		if (x < 0 || y < 0 || x >= M || y >= N)
			return;

		if (map[x][y] == 1) {
			map[x][y] = -1;
			checkSizeOfField(x - 1, y);
			checkSizeOfField(x + 1, y);
			checkSizeOfField(x, y - 1);
			checkSizeOfField(x, y + 1);
		}
	}
}
