/*
 * ¹Ì·Î Å½»ö
 * https://www.acmicpc.net/problem/2178
 */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2178 {
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int[][] map = new int[N + 1][M + 1];
		int[][] visited = new int[N + 1][M + 1];
		class point {
			int x;
			int y;

			public point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		for (int i = 1; i <= N; i++) {
			String temp = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = temp.charAt(j - 1) - '0';
			}
		}

		Queue<point> q = new LinkedList();
		q.add(new point(1, 1));
		visited[1][1] = 1;
		int step = 0;
		while (!q.isEmpty()) {
			step++;
			int size = q.size();

			while (size-- > 0) {
				point temp = q.poll();
				int cx = temp.x;
				int cy = temp.y;
				if (cx == N && cy == M) {
					System.out.print(step);
					return;
				}

				for (int d = 0; d < 4; d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];

					if (!checkRange(nx, ny) || map[nx][ny] != 1 || visited[nx][ny] == 1)
						continue;

					q.add(new point(nx, ny));
					visited[nx][ny] = 1;
				}
			}
		}
	}

	public static boolean checkRange(int x, int y) {
		return x >= 1 && y >= 1 && x <= N && y <= M;
	}
}
