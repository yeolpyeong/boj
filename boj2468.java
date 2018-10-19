/*
 * 안전 영역
 * https://www.acmicpc.net/problem/2468
 */

package boj;

import java.util.Scanner;

public class boj2468 {
	static int N;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] flooded;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] map = new int[N + 1][N + 1];
		int highest = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				highest = Math.max(highest, map[i][j]);
			}
		}

		int max = 0;
		for (int h = 0; h <= highest; h++) {
			flooded = new boolean[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					flooded[i][j] = map[i][j] <= h ? true : false;
				}
			}

			int nSafeArea = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!flooded[i][j]) {
						nSafeArea++;
						bfs(i, j);
					}
				}
			}
			max = Math.max(max, nSafeArea);
		}
		System.out.print(max);
	}

	public static void bfs(int cx, int cy) {
		flooded[cx][cy] = true;
		for (int d = 0; d < 4; d++) {
			int nx = cx + dx[d];
			int ny = cy + dy[d];

			if (!checkRange(nx, ny))
				continue;

			if (!flooded[nx][ny])
				bfs(nx, ny);
		}
	}

	public static boolean checkRange(int x, int y) {
		return x >= 1 && y >= 1 && x <= N && y <= N;
	}
}
