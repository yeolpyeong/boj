
/*
 * 탈옥
 * https://www.acmicpc.net/problem/9376
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj9376 {
	static char BLANK = '.', WALL = '*', DOOR = '#', PRISONER = '$';
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int h, w;
	static char[][] map;

	static int[][] bfs(Point p) {
		Queue<Point> q = new LinkedList<>();
		int[][] dist = new int[h + 2][w + 2];
		for (int i = 0; i < h + 2; i++) {
			for (int j = 0; j < w + 2; j++) {
				dist[i][j] = -1;
			}
		}
		q.add(p);
		dist[p.x][p.y] = map[p.x][p.y] == DOOR ? 1 : 0;
		while (!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.peek().y;
			q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) {
					continue;
				}

				if (map[nx][ny] == WALL) {
					continue;
				}

				if (map[nx][ny] == BLANK || map[nx][ny] == PRISONER) {
					if (dist[nx][ny] == -1 || dist[nx][ny] > dist[cx][cy]) {
						q.add(new Point(nx, ny));
						dist[nx][ny] = dist[cx][cy];
					}
				} else if (map[nx][ny] == DOOR) {
					if (dist[nx][ny] == -1 || dist[nx][ny] > dist[cx][cy] + 1) {
						q.add(new Point(nx, ny));
						dist[nx][ny] = dist[cx][cy] + 1;
					}
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h + 2][w + 2];
			Point prisoner1 = new Point(-1, -1);
			Point prisoner2 = new Point(-1, -1);
			Point helper = new Point(0, 0);
			for (int i = 1; i <= h; i++) {
				String line = br.readLine();
				for (int j = 1; j <= w; j++) {
					map[i][j] = line.charAt(j - 1);
					if (map[i][j] == PRISONER) {
						if (prisoner1.x == -1) {
							prisoner1.x = i;
							prisoner1.y = j;
						} else {
							prisoner2.x = i;
							prisoner2.y = j;
						}
					}
				}
			}
			for (int i = 0; i < h + 2; i++) {
				map[i][0] = map[i][w + 1] = BLANK;
			}
			for (int i = 0; i < w + 2; i++) {
				map[0][i] = map[h + 1][i] = BLANK;
			}

			int min = Integer.MAX_VALUE;
			int[][] sum = new int[h + 2][w + 2];
			int[][] dist1 = bfs(prisoner1);
			int[][] dist2 = bfs(prisoner2);
			int[][] dist3 = bfs(helper);
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (map[i][j] == WALL) {
						continue;
					}

					sum[i][j] += dist1[i][j] + dist2[i][j] + dist3[i][j];
					if (map[i][j] == DOOR) {
						sum[i][j] -= 2;
					}

					min = Math.min(min, sum[i][j]);
				}
			}

			System.out.println(min);
		}
	}
}
