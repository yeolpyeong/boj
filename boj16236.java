
/*
 * 아기 상어
 * https://www.acmicpc.net/problem/16236
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class boj16236 {
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point o) {
			int diffX = this.x - o.x;
			int diffY = this.y - o.y;
			return diffX != 0 ? diffX : diffY;
		}
	}

	static int N, x, y, second, size = 2, theNumberOfEaten;
	static int[][] map;

	static boolean goToEat() {
		boolean didSharkEat = false;
		second = -1;
		map[x][y] = 0;

		PriorityQueue<Point> pq = new PriorityQueue<>();
		PriorityQueue<Point> temp = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		pq.add(new Point(x, y));
		visited[x][y] = true;
		loop: while (!pq.isEmpty()) {
			second++;
			int qs = pq.size();
			while (qs-- > 0) {
				int cx = pq.peek().x;
				int cy = pq.peek().y;
				pq.poll();

				if (map[cx][cy] != 0 && map[cx][cy] < size) {
					theNumberOfEaten++;
					if (theNumberOfEaten == size) {
						size++;
						theNumberOfEaten = 0;
					}

					map[cx][cy] = 9;
					didSharkEat = true;
					x = cx;
					y = cy;

					break loop;
				}

				for (int d = 0; d < 4; d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
						continue;
					}

					if (map[nx][ny] > size || visited[nx][ny]) {
						continue;
					}

					temp.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
			pq = temp;
			temp = new PriorityQueue<>();
		}
		return didSharkEat;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		x = -1;
		y = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = i;
					y = j;
				}
			}
		}

		int total = 0;
		while (true) {
			if (!goToEat()) {
				break;
			}

			total += second;
		}

		System.out.print(total);
	}
}
