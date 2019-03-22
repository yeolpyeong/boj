
/*
 * Super 2048 (Large)
 * https://www.acmicpc.net/problem/12209
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj12209 {
	static int N;
	static int[][] board;

	static void rotate(int d) {
		int[][] copy;
		while (d-- > 0) {
			copy = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					copy[i][j] = board[N - 1 - j][i];
				}
			}

			board = copy;
		}
	}

	static void combine() {
		int x, v;
		for (int j = N - 1; j >= 0; j--) {
			x = -1;
			v = -1;
			for (int i = N - 1; i >= 0; i--) {
				if (board[i][j] == 0) {
					continue;
				}

				if (board[i][j] == v) {
					board[x][j] = 2 * v;
					board[i][j] = 0;
					v = -1;
				} else {
					x = i;
					v = board[i][j];
				}
			}
		}
	}

	static void moveDown() {
		int step;
		for (int j = N - 1; j >= 0; j--) {
			step = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (board[i][j] == 0) {
					step++;
				} else if (step > 0) {
					board[i + step][j] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String DIR = st.nextToken();
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int d = -1;
			switch (DIR) {
			case "left":
				d = 3;
				break;
			case "right":
				d = 1;
				break;
			case "up":
				d = 2;
				break;
			case "down":
				d = 0;
				break;
			}

			rotate(d);
			combine();
			moveDown();
			rotate(4 - d);

			System.out.printf("Case #%d: \n", t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("%d ", board[i][j]);
				}
				System.out.println();
			}
		}
	}
}
