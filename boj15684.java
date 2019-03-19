
/*
 * 사다리 조작
 * https://www.acmicpc.net/problem/15684
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj15684 {
	static int N, H, count = -1;
	static boolean[][] row;

	static boolean ladder() {
		boolean flag = true;
		int src = -1;
		for (int j = 1; j <= N; j++) {
			src = j;
			for (int i = 1; i <= H; i++) {
				if (row[i][src]) {
					src++;
				} else if (row[i][src - 1]) {
					src--;
				}
			}

			if (src != j) {
				flag = false;
			}
		}
		return flag;
	}

	static void dfs(int depth, int r) {
		if (depth > 3) {
			return;
		}

		if (ladder()) {
			count = depth;
			return;
		}

		if (count > -1) {
			return;
		}

		for (int i = r; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (row[i][j] || row[i][j - 1] || row[i][j + 1]) {
					continue;
				}

				row[i][j] = true;
				dfs(depth + 1, i);
				row[i][j] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		row = new boolean[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			row[a][b] = true;
		}

		dfs(0, 1);

		System.out.print(count);
	}
}
