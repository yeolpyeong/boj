
/*
 * 토마토
 * https://www.acmicpc.net/problem/7576
 */

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

class boj7576 {
	static final int ripe = 1, unripe = 0;
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int day = -1;

	static void bfs(int[][] box) {
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if (box[i][j] == ripe) {
					q.add(new Point(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			day++;
			int qs = q.size();
			while (qs-- > 0) {
				int cx = q.peek().x;
				int cy = q.peek().y;
				q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];

					if (nx < 0 || ny < 0 || nx >= box.length || ny >= box[0].length) {
						continue;
					}

					if (box[nx][ny] != unripe) {
						continue;
					}

					box[nx][ny] = ripe;
					q.add(new Point(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(box);

		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == unripe) {
					flag = false;
				}
			}
		}

		System.out.print(flag ? day : -1);
	}
}
