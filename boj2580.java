
/*
 * 스도쿠
 * https://www.acmicpc.net/problem/2580
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj2580 {
	static final int SIZE = 9, BLANK = 0;

	static int cr, cc;
	static int[][] board;

	static boolean findBlank() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == BLANK) {
					cr = i;
					cc = j;
					return true;
				}
			}
		}
		return false;
	}

	static boolean checkRow(int r, int n) {
		for (int i = 0; i < SIZE; i++) {
			if (board[r][i] == n) {
				return false;
			}
		}
		return true;
	}

	static boolean checkCol(int c, int n) {
		for (int i = 0; i < SIZE; i++) {
			if (board[i][c] == n) {
				return false;
			}
		}
		return true;
	}

	static boolean checkBox(int r, int c, int n) {
		int tempR = r / 3 * 3;
		int tempC = c / 3 * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[tempR + i][tempC + j] == n) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean sudoku() {
		int r = 0;
		int c = 0;

		if (!findBlank()) {
			return true;
		}

		r = cr;
		c = cc;
		for (int n = 1; n <= SIZE; n++) {
			if (checkRow(r, n) && checkCol(c, n) && checkBox(r, c, n)) {
				board[r][c] = n;
				if (sudoku()) {
					return true;
				}
				board[r][c] = BLANK;
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sudoku();

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.printf("%d ", board[i][j]);
			}
			System.out.println();
		}
	}
}
