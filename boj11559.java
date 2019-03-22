
/*
 * Puyo Puyo
 * https://www.acmicpc.net/problem/11559
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class boj11559 {
	static final int ROW = 12, COL = 6;
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;

	static void moveDown() {
		int step;
		for (int j = COL; j >= 1; j--) {
			step = 0;
			for (int i = ROW; i >= 1; i--) {
				if (map[i][j] == '.') {
					step++;
				} else if (step > 0) {
					map[i + step][j] = map[i][j];
					map[i][j] = '.';
				}
			}
		}
	}

	static boolean bomb() {
		boolean flag = false;
		boolean[][] visited = new boolean[ROW + 1][COL + 1];
		Queue<Point> q1, q2;
		for (int i = ROW; i >= 1; i--) {
			for (int j = COL; j >= 1; j--) {
				if (map[i][j] == '.' || visited[i][j]) {
					continue;
				}

				q1 = new LinkedList<>();
				q2 = new LinkedList<>();
				q1.add(new Point(i, j));
				q2.add(new Point(i, j));
				visited[i][j] = true;
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

						if (map[nx][ny] != map[cx][cy] || visited[nx][ny]) {
							continue;
						}

						q1.add(new Point(nx, ny));
						q2.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}

				if (q2.size() >= 4) {
					flag = true;

					while (!q2.isEmpty()) {
						int x = q2.peek().x;
						int y = q2.peek().y;
						q2.poll();

						map[x][y] = '.';
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
				map[i][j] = line.charAt(j - 1);
			}
		}

		int count = 0;
		moveDown();
		while (bomb()) {
			count++;
			moveDown();
		}

		System.out.print(count);
	}
}
