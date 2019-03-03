/*
 * Baaaaaaaaaduk2 (Easy)
 * https://www.acmicpc.net/problem/16988
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj16988 {
	static final int blank = 0, mine = 1, yours = 2;
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, surrounded;

	public static int countSurrounded(int[][] board) {
		int total = 0;
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (board[i][j] == yours && !visited[i][j]) {
					int count = 1;
					boolean flag = true;
					visited[i][j] = true;
					q.add(new Point(i, j));
					while (!q.isEmpty()) {
						int cx = q.peek().x;
						int cy = q.peek().y;
						q.poll();

						for (int d = 0; d < 4; d++) {
							int nx = cx + dx[d];
							int ny = cy + dy[d];

							if (visited[nx][ny]) {
								continue;
							}

							if (board[nx][ny] == blank) {
								flag = false;
							} else if (board[nx][ny] == yours) {
								visited[nx][ny] = true;
								count++;
								q.add(new Point(nx, ny));
							}
						}
					}

					if (flag && count > 0) {
						total += count;
					}
				}
			}
		}

		return total;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			board[i][0] = board[i][M + 1] = mine;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				board[0][j] = board[N + 1][j] = mine;
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int a = 1; a <= N; a++) {
			for (int b = 1; b <= M; b++) {
				if (board[a][b] != blank) {
					continue;
				}

				for (int c = a; c <= N; c++) {
					for (int d = 1; d <= M; d++) {
						if (a == c && b == d) {
							continue;
						}

						if (board[c][d] != blank) {
							continue;
						}

						board[a][b] = board[c][d] = mine;
						int total = countSurrounded(board);
						if (total > surrounded) {
							surrounded = total;
						}
						board[a][b] = board[c][d] = blank;
					}
				}
			}
		}

		System.out.print(surrounded);
	}
}
