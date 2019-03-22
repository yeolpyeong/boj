
/*
 * 2048 (Easy)
 * https://www.acmicpc.net/problem/12100
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class boj12100 {
	static int N, max = Integer.MIN_VALUE;
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

	static void dfs(int[][] original, Stack<Integer> stack) {
		if (stack.size() == 5) {
			for (int i = 0; i < N; i++) {
				board[i] = original[i].clone();
			}

			for (int d : stack) {
				rotate(d);
				combine();
				moveDown();
				rotate(4 - d);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, board[i][j]);
				}
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			stack.push(d);
			dfs(original, stack);
			stack.pop();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] original = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		board = new int[N][N];
		dfs(original, new Stack<>());

		System.out.print(max);
	}
}
