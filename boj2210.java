/*
 * 숫자판 점프
 * https://www.acmicpc.net/problem/2210
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj2210 {
	static final int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] board;
	static Set<String> numbers = new HashSet<>();

	public static void dfs(String number, int cx, int cy) {
		if (number.length() == 6) {
			numbers.add(number);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = cx + dx[d];
			int ny = cy + dy[d];

			if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
				continue;
			}

			dfs(number + board[nx][ny], nx, ny);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs("", i, j);
			}
		}

		System.out.print(numbers.size());
	}
}
