
/*
 * ≈‰∏∂≈‰
 * https://www.acmicpc.net/problem/7569
 */

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

class boj7569 {
	static final int ripe = 1, unripe = 0;
	static final int[] dx = { 1, -1, 0, 0, 0, 0 }, dy = { 0, 0, 1, -1, 0, 0 }, dz = { 0, 0, 0, 0, 1, -1 };

	static class Point {
		int x, y, z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int day = -1;

	static void bfs(int[][][] boxes) {
		Queue<Point> q = new LinkedList<>();
		for (int k = 0; k < boxes[0][0].length; k++) {
			for (int i = 0; i < boxes.length; i++) {
				for (int j = 0; j < boxes[0].length; j++) {
					if (boxes[i][j][k] == ripe) {
						q.add(new Point(i, j, k));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			day++;
			int qs = q.size();
			while (qs-- > 0) {
				int cx = q.peek().x;
				int cy = q.peek().y;
				int cz = q.peek().z;
				q.poll();

				for (int d = 0; d < 6; d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];
					int nz = cz + dz[d];

					if (nx < 0 || ny < 0 || nz < 0 || nx >= boxes.length || ny >= boxes[0].length
							|| nz >= boxes[0][0].length) {
						continue;
					}

					if (boxes[nx][ny][nz] != unripe) {
						continue;
					}

					boxes[nx][ny][nz] = ripe;
					q.add(new Point(nx, ny, nz));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] boxes = new int[N][M][H];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					boxes[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		bfs(boxes);

		boolean flag = true;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (boxes[i][j][k] == unripe) {
						flag = false;
					}
				}
			}
		}

		System.out.print(flag ? day : -1);
	}
}
