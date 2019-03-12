
/*
 * Puyo Puyo
 * https://www.acmicpc.net/problem/11559
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class boj11559 {
	static final int ROW = 12, COL = 6, BOMB = -1, BLANK = 0;
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int count;
	static int[][] map;

	static Queue<Point> bfs(boolean[][] visited, int x, int y, int color) {
		Queue<Point> q1 = new LinkedList<>();
		Queue<Point> q2 = new LinkedList<>();
		q1.add(new Point(x, y));
		q2.add(new Point(x, y));
		visited[x][y] = true;
		while (!q1.isEmpty()) {
			int cx = q1.peek().x;
			int cy = q1.peek().y;
			q1.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx < 1 || ny < 1 || nx > ROW || ny > COL) {
					continue;
				}

				if (map[nx][ny] != color || visited[nx][ny]) {
					continue;
				}

				q1.add(new Point(nx, ny));
				q2.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}

		if (q2.size() < 4) {
			q2.clear();
		}

		return q2;
	}

	static void restore() {
		for (int j = COL; j >= 1; j--) {
			int step = 0;
			for (int i = ROW; i >= 0; i--) {
				if (map[i][j] == BLANK || (step > 0 && map[i][j] > 0)) {
					for (int k = step; k >= 1; k--) {
						map[i + k][j] = i + k > ROW ? 0 : map[i][j];
					}
					continue;
				}

				if (map[i][j] == BOMB) {
					step++;
				}
			}
		}
	}

	static boolean bomb() {
		boolean flag = false;
		boolean[][] visited = new boolean[ROW + 1][COL + 1];
		for (int i = ROW; i >= 1; i--) {
			for (int j = COL; j >= 1; j--) {
				if (map[i][j] == BLANK || visited[i][j]) {
					continue;
				}

				Queue<Point> q = bfs(visited, i, j, map[i][j]);
				if (q.size() >= 4) {
					flag = true;
					while (!q.isEmpty()) {
						int x = q.peek().x;
						int y = q.peek().y;
						q.poll();

						map[x][y] = BOMB;
					}
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[ROW + 1][COL + 1];
		for (int i = 1; i <= ROW; i++) {
			String line = br.readLine();
			for (int j = 1; j <= COL; j++) {
				map[i][j] = line.charAt(j - 1) == '.' ? BOMB : line.charAt(j - 1);
			}
		}

		restore();
		while (true) {
			if (!bomb()) {
				break;
			}

			restore();
			count++;
		}

		System.out.print(count);
	}
}
