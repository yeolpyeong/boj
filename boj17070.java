
/*
 * 파이프 옮기기 1
 * https://www.acmicpc.net/problem/17070
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj17070 {
	static final int[] dx = { 0, 1, 1 }, dy = { 1, 0, 1 };

	static int N, count;
	static int[][] map;

	static boolean inRange(int x, int y) {
		return x <= N && y <= N;
	}

	static void dfs(int cx, int cy, int d) {
		if (cx == N && cy == N) {
			count++;
			return;
		}

		if (d < 2) {
			int nx = cx + dx[d], ny = cy + dy[d];
			if (inRange(nx, ny) && map[nx][ny] == 0) {
				dfs(nx, ny, d);
			}
		} else {
			for (int i = 0; i < 2; i++) {
				int nx = cx + dx[i], ny = cy + dy[i];
				if (inRange(nx, ny) && map[nx][ny] == 0) {
					dfs(nx, ny, i);
				}
			}
		}

		boolean flag = true;
		for (int i = 0; i < 3; i++) {
			int nx = cx + dx[i], ny = cy + dy[i];
			if (!(inRange(nx, ny) && map[nx][ny] == 0)) {
				flag = false;
			}
		}
		if (flag) {
			dfs(cx + 1, cy + 1, 2);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 2, 0);

		System.out.print(count);
	}
}
