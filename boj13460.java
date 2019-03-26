
/*
 * 구슬 탈출 2
 * https://www.acmicpc.net/problem/13460
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj13460 {
	static final int MAX = 10;
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Bead {
		int rx, ry, bx, by, count;
	}

	static int N, M;
	static char[][] board;

	static int bfs() {
		Bead start = new Bead();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'R') {
					start.rx = i;
					start.ry = j;
				}
				if (board[i][j] == 'B') {
					start.bx = i;
					start.by = j;
				}
			}
		}
		start.count = 0;

		Queue<Bead> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[MAX][MAX][MAX][MAX];
		q.add(start);
		visited[start.rx][start.ry][start.bx][start.by] = true;
		int ret = -1;
		while (!q.isEmpty()) {
			Bead cb = q.poll();

			if (cb.count > 10) {
				break;
			}

			if (board[cb.rx][cb.ry] == 'O' && board[cb.bx][cb.by] != 'O') {
				ret = cb.count;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nrx = cb.rx;
				int nry = cb.ry;
				int nbx = cb.bx;
				int nby = cb.by;

				while (true) {
					if (board[nrx][nry] != '#' && board[nrx][nry] != 'O') {
						nrx += dx[d];
						nry += dy[d];
					} else {
						if (board[nrx][nry] == '#') {
							nrx -= dx[d];
							nry -= dy[d];
						}
						break;
					}
				}

				while (true) {
					if (board[nbx][nby] != '#' && board[nbx][nby] != 'O') {
						nbx += dx[d];
						nby += dy[d];
					} else {
						if (board[nbx][nby] == '#') {
							nbx -= dx[d];
							nby -= dy[d];
						}
						break;
					}
				}

				if (nrx == nbx && nry == nby) {
					if (board[nrx][nry] != 'O') {
						int rd = Math.abs(nrx - cb.rx) + Math.abs(nry - cb.ry);
						int bd = Math.abs(nbx - cb.bx) + Math.abs(nby - cb.by);
						if (rd > bd) {
							nrx -= dx[d];
							nry -= dy[d];
						} else {
							nbx -= dx[d];
							nby -= dy[d];
						}
					}
				}

				if (!visited[nrx][nry][nbx][nby]) {
					visited[nrx][nry][nbx][nby] = true;
					Bead nb = new Bead();
					nb.rx = nrx;
					nb.ry = nry;
					nb.bx = nbx;
					nb.by = nby;
					nb.count = cb.count + 1;
					q.add(nb);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		System.out.print(bfs());
	}
}
