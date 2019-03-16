
/*
 * 인구 이동
 * https://www.acmicpc.net/problem/16234
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj16234 {
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int L, R;

	static ArrayList<ArrayList<Point>> open(int[][] map) {
		int N = map.length;
		Queue<Point> q = new LinkedList<>();
		ArrayList<ArrayList<Point>> adj = new ArrayList<>();
		int union = -1;
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					continue;
				}

				q.add(new Point(i, j));
				adj.add(new ArrayList<>());
				union++;
				adj.get(union).add(new Point(i, j));
				visited[i][j] = true;
				while (!q.isEmpty()) {
					int cx = q.peek().x;
					int cy = q.peek().y;
					q.poll();

					for (int d = 0; d < 4; d++) {
						int nx = cx + dx[d];
						int ny = cy + dy[d];

						if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
							continue;
						}

						if (visited[nx][ny]) {
							continue;
						}

						int dist = Math.abs(map[cx][cy] - map[nx][ny]);
						if (dist >= L && dist <= R) {
							q.add(new Point(nx, ny));
							adj.get(union).add(new Point(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		return adj;
	}

	static void move(int[][] map, ArrayList<ArrayList<Point>> adj) {
		int N = map.length;
		for (int i = 0; i < adj.size(); i++) {
			ArrayList<Point> union = adj.get(i);
			int sum = 0;
			for (Point country : union) {
				sum += map[country.x][country.y];
			}
			for (Point country : union) {
				map[country.x][country.y] = sum / union.size();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int moving = -1;
		ArrayList<ArrayList<Point>> adj;
		do {
			adj = open(A);
			move(A, adj);
			moving++;
		} while (adj.size() != N * N);

		System.out.println(moving);
	}
}
