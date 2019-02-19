
/*
 * 알파벳
 * https://www.acmicpc.net/problem/1987
 */

import java.util.Scanner;

public class boj1987 {
	static int R, C, count, max;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[] visited;

	public static void dfs(int cx, int cy) {
		++count;
		visited[map[cx][cy]] = true;
		for (int d = 0; d < 4; ++d) {
			int nx = cx + dx[d];
			int ny = cy + dy[d];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
				continue;
			}

			if (!visited[map[nx][ny]]) {
				dfs(nx, ny);
			}
		}

		if (max < count) {
			max = count;
		}

		--count;
		visited[map[cx][cy]] = false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		visited = new boolean[26];
		for (int i = 0; i < R; ++i) {
			String line = sc.next();
			for (int j = 0; j < C; ++j) {
				map[i][j] = line.charAt(j) - 'A';
			}
		}

		dfs(0, 0);
		System.out.print(max);
	}
}
