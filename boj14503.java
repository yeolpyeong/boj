/*
 * 로봇 청소기
 * https://www.acmicpc.net/problem/14503
 */

package boj;

import java.util.Scanner;

public class boj14503 {
	static int N, M, totalSumOfCleanSpace = 0;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] map = new int[51][51];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int r = sc.nextInt() + 1;
		int c = sc.nextInt() + 1;
		int d = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		map[r][c] = -1;
		totalSumOfCleanSpace += 1;
		boj14503(r, c, d);
		System.out.println(totalSumOfCleanSpace);
	}

	public static void boj14503(int x, int y, int d) {
		int nAdjacentCleanSpace = 0;
		while (true) {
			if (map[x + dx[d]][y + dy[d]] == 0) {
				totalSumOfCleanSpace += 1;
				map[x += dx[d]][y += dy[d]] = -1;
				d = (d + 3) % 4;
				nAdjacentCleanSpace = 0;
				continue;
			} else {
				d = (d + 3) % 4;
				nAdjacentCleanSpace++;
			}

			if (nAdjacentCleanSpace == 4) {
				x += dx[(d + 3) % 4];
				y += dy[(d + 3) % 4];
				nAdjacentCleanSpace = 0;
			}

			if (map[x][y] == 1)
				break;
		}
	}
}
