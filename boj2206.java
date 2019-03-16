
/*
 * 벽 부수고 이동하기
 * https://www.acmicpc.net/problem/2206
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj2206 {
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Point {
		int x, y, d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int min = -1;

	static void bfs(int[][] map) {
		int N = map.length - 1;
		int M = map[0].length - 1;

		Queue<Point> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N + 1][M + 1][2];
		if (map[1][1] == 0) {
			q.add(new Point(1, 1, 0));
			visited[1][1][0] = true;
		} else {
			q.add(new Point(1, 1, 1));
			visited[1][1][1] = true;
		}
		int step = 0;
		loop: while (!q.isEmpty()) {
			step++;
			int qs = q.size();
			while (qs-- > 0) {
				int cx = q.peek().x;
				int cy = q.peek().y;
				int cd = q.peek().d;
				q.poll();

				if (cx == N && cy == M) {
					min = step;
					break loop;
				}

				for (int d = 0; d < 4; d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];

					if (nx < 1 || ny < 1 || nx > N || ny > M) {
						continue;
					}

					if (map[nx][ny] == 0) {
						if (!visited[nx][ny][cd]) {
							q.add(new Point(nx, ny, cd));
							visited[nx][ny][cd] = true;
						}
					} else {
						if (cd == 0 && !visited[nx][ny][1]) {
							q.add(new Point(nx, ny, 1));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}

		bfs(map);

		System.out.print(min);
	}
}
