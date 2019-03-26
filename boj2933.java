
/*
 * ¹Ì³×¶ö
 * https://www.acmicpc.net/problem/2933
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class boj2933 {
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return o.x - this.x;
		}
	}

	static int R, C, min;
	static char[][] cave;
	static boolean separated;

	static Point throwAStick(int d, int h) {
		int w = -1;
		if (d == 'L') {
			for (int i = 0; i < C; i++) {
				if (cave[h][i] == 'x') {
					w = i;
					cave[h][w] = '.';
					break;
				}
			}
		} else {
			for (int i = C - 1; i >= 0; i--) {
				if (cave[h][i] == 'x') {
					w = i;
					cave[h][w] = '.';
					break;
				}
			}
		}
		return new Point(h, w);
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y < C;
	}

	static PriorityQueue<Point> bfs(Point p) {
		separated = true;
		min = Integer.MAX_VALUE;
		PriorityQueue<Point> pq1 = new PriorityQueue<>();
		PriorityQueue<Point> pq2 = new PriorityQueue<>();
		boolean[][] visited = new boolean[R][C];
		pq1.add(p);
		pq2.add(p);
		visited[p.x][p.y] = true;
		while (!pq1.isEmpty()) {
			int cx = pq1.peek().x;
			int cy = pq1.peek().y;
			pq1.poll();

			int dist = 0;
			for (int i = cx + 1; i < R; i++) {
				if (cave[i][cy] == 'x' && !visited[i][cy]) {
					break;
				}

				dist++;
			}

			if (dist != 0) {
				min = Math.min(min, dist);
			}

			if (cx == R - 1) {
				separated = false;
				pq2.clear();
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (!inRange(nx, ny)) {
					continue;
				}

				if (cave[nx][ny] == '.' || visited[nx][ny]) {
					continue;
				}

				pq1.add(new Point(nx, ny));
				pq2.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
		return pq2;
	}

	static void moveDown(PriorityQueue<Point> pq) {
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			cave[p.x + min][p.y] = 'x';
			cave[p.x][p.y] = '.';
		}
	}

	static void isItSeparated(Point p) {
		separated = false;
		for (int d = 0; d < 4; d++) {
			int nx = p.x + dx[d];
			int ny = p.y + dy[d];

			if (!inRange(nx, ny)) {
				continue;
			}

			if (!separated && cave[nx][ny] == 'x') {
				PriorityQueue<Point> pq = bfs(new Point(nx, ny));
				if (separated) {
					moveDown(pq);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cave = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				cave[i][j] = line.charAt(j);
			}
		}
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int h = R - Integer.parseInt(st.nextToken());
			if (i % 2 == 0) {
				Point destoryed = throwAStick('L', h);
				isItSeparated(destoryed);
			} else {
				Point destoryed = throwAStick('R', h);
				isItSeparated(destoryed);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.printf("%c", cave[i][j]);
			}
			System.out.println();
		}
	}
}
