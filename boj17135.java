
/*
 * 캐슬 디펜스
 * https://www.acmicpc.net/problem/17135
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class boj17135 {
	static final int[] dr = { -1, 0, 0 }, dc = { 0, -1, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, D, max = Integer.MIN_VALUE;
	static int[][] map;

	static void bfs(Stack<Integer> archers) {
		int[][] copy = new int[N][M];
		int nEnemies = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
				if (copy[i][j] == 1) {
					nEnemies++;
				}
			}
		}

		int count = 0;
		Queue<Point> targets = new LinkedList<>();
		while (nEnemies > 0) {
			for (int archer : archers) {
				Queue<Point> q = new LinkedList<>();
				boolean[][] visited = new boolean[N][M];
				q.add(new Point(N, archer));
				int dist = 0;
				Point target = new Point(N, M);
				do {
					dist++;
					int qs = q.size();
					while (qs-- > 0) {
						int cr = q.peek().r;
						int cc = q.peek().c;
						q.poll();

						for (int d = 0; d < 3; d++) {
							int nr = cr + dr[d];
							int nc = cc + dc[d];

							if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
								continue;
							}

							if (visited[nr][nc]) {
								continue;
							}

							if (copy[nr][nc] == 1) {
								if (nc < target.c) {
									target.r = nr;
									target.c = nc;
								}
							} else {
								q.add(new Point(nr, nc));
								visited[nr][nc] = true;
							}
						}
					}
				} while (dist < D && target.r == N);

				if (target.r != N) {
					targets.add(target);
				}
			}

			while (!targets.isEmpty()) {
				int tr = targets.peek().r;
				int tc = targets.peek().c;
				targets.poll();

				if (copy[tr][tc] == 1) {
					copy[tr][tc] = 0;
					count++;
					nEnemies--;
				}
			}

			for (int i = N - 1; i >= 0; i--) {
				for (int j = M - 1; j >= 0; j--) {
					if (copy[i][j] == 1) {
						copy[i][j] = 0;
						if (i < N - 1) {
							copy[i + 1][j] = 1;
						} else if (i == N - 1) {
							nEnemies--;
						}
					}
				}
			}
		}

		if (count > max) {
			max = count;
		}
	}

	static void dfs(Stack<Integer> stack, int idx) {
		if (idx == 3) {
			bfs(stack);
			return;
		}

		for (int i = idx; i < M; i++) {
			stack.push(i);
			dfs(stack, idx + 1);
			stack.pop();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(new Stack<>(), 0);

		System.out.println(max);
	}
}
