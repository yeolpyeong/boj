
/*
 * °¨½Ã
 * https://www.acmicpc.net/problem/15683
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class boj15683 {
	static final int[] direction = { 0, 4, 2, 4, 4, 1 }, dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class CCTV {
		int x, y, c;

		public CCTV(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static int N, M, max = Integer.MIN_VALUE;
	static int[][] map, watched;

	static void check(int cx, int cy, int d) {
		int nx = cx, ny = cy;
		while (true) {
			nx += dx[d];
			ny += dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				break;
			}

			if (map[nx][ny] == 6) {
				break;
			}

			if (map[nx][ny] != 0) {
				continue;
			}

			watched[nx][ny]++;
		}
	}

	static void watch(ArrayList<CCTV> CCTVs, Stack<Integer> stack) {
		watched = new int[N][M];
		for (int i = CCTVs.size() - 1; i >= 0; i--) {
			int cx = CCTVs.get(i).x;
			int cy = CCTVs.get(i).y;
			int cc = CCTVs.get(i).c;
			int d = stack.pop();

			switch (cc) {
			case 1:
				check(cx, cy, d);
				break;
			case 2:
				if (d == 0) {
					check(cx, cy, 0);
					check(cx, cy, 1);
				} else if (d == 1) {
					check(cx, cy, 2);
					check(cx, cy, 3);
				}
				break;
			case 3:
				if (d == 0) {
					check(cx, cy, 0);
					check(cx, cy, 2);
				} else if (d == 1) {
					check(cx, cy, 0);
					check(cx, cy, 3);
				} else if (d == 2) {
					check(cx, cy, 1);
					check(cx, cy, 2);
				} else if (d == 3) {
					check(cx, cy, 1);
					check(cx, cy, 3);
				}
				break;
			case 4:
				if (d == 0) {
					check(cx, cy, 0);
					check(cx, cy, 1);
					check(cx, cy, 2);
				} else if (d == 1) {
					check(cx, cy, 0);
					check(cx, cy, 1);
					check(cx, cy, 3);
				} else if (d == 2) {
					check(cx, cy, 0);
					check(cx, cy, 2);
					check(cx, cy, 3);
				} else if (d == 3) {
					check(cx, cy, 1);
					check(cx, cy, 2);
					check(cx, cy, 3);
				}
				break;
			case 5:
				check(cx, cy, 0);
				check(cx, cy, 1);
				check(cx, cy, 2);
				check(cx, cy, 3);
				break;
			}
		}
	}

	static void dfs(ArrayList<CCTV> CCTVs, Stack<Integer> stack) {
		if (stack.size() == CCTVs.size()) {
			watch(CCTVs, (Stack<Integer>) stack.clone());

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (watched[i][j] > 0) {
						count++;
					}
				}
			}

			max = Math.max(max, count);
			return;
		}

		for (int d = 0; d < direction[CCTVs.get(stack.size()).c]; d++) {
			stack.push(d);
			dfs(CCTVs, stack);
			stack.pop();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int res = 0;
		ArrayList<CCTV> CCTVs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					res++;
				}
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					CCTVs.add(new CCTV(i, j, map[i][j]));
				}
			}
		}

		Stack<Integer> stack = new Stack<>();
		dfs(CCTVs, stack);

		System.out.print(res - max);
	}
}
