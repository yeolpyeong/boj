
/*
 * 체스
 * https://www.acmicpc.net/problem/1986
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class boj1986 {
	static final int Blank = 0, Queen = 1, Knight = 2, Pawn = 3;
	static final int[] qx = { 1, -1, 0, 0, 1, 1, -1, -1 }, qy = { 0, 0, 1, -1, 1, -1, 1, -1 },
			kx = { 1, 1, -1, -1, 2, 2, -2, -2 }, ky = { 2, -2, 2, -2, 1, -1, 1, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static int[][] board;

	static boolean inRange(int x, int y) {
		return x >= 1 && y >= 1 && x <= n && y <= m;
	}

	static void whereQueenCanGo(int cx, int cy, int d) {
		int nx = cx + qx[d];
		int ny = cy + qy[d];

		if (!inRange(nx, ny)) {
			return;
		}

		if (board[nx][ny] > Blank) {
			return;
		}

		board[nx][ny] = -Queen;
		whereQueenCanGo(nx, ny, d);
	}

	static void whereKnightCanGo(int cx, int cy, int d) {
		int nx = cx + kx[d];
		int ny = cy + ky[d];

		if (!inRange(nx, ny)) {
			return;
		}

		if (board[nx][ny] > Blank) {
			return;
		}

		board[nx][ny] = -Knight;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n + 1][m + 1];
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			board[sc.nextInt()][sc.nextInt()] = Queen;
		}
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			board[sc.nextInt()][sc.nextInt()] = Knight;
		}
		int p = sc.nextInt();
		for (int i = 0; i < p; i++) {
			board[sc.nextInt()][sc.nextInt()] = Pawn;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (board[i][j] == Queen) {
					for (int d = 0; d < 8; d++) {
						whereQueenCanGo(i, j, d);
					}
				} else if (board[i][j] == Knight) {
					for (int d = 0; d < 8; d++) {
						whereKnightCanGo(i, j, d);
					}
				}
			}
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (board[i][j] == Blank) {
					count++;
				}
			}
		}

		System.out.print(count);
	}
}
