
/*
 * 색종이 붙이기
 * https://www.acmicpc.net/problem/17136
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj17136 {
	static int min = -1;
	static int[] type = new int[6];
	static int[][] map = new int[10][10];

	static boolean check(int cr, int cc, int k) {
		for (int i = 0; i < k; i++) {
			if (cr + i >= 10 || cc + k - 1 >= 10) {
				return false;
			}

			if (map[cr + i][cc + k - 1] == 0) {
				return false;
			}
		}
		for (int i = 0; i < k; i++) {
			if (cr + k - 1 >= 10 || cc + i >= 10) {
				return false;
			}

			if (map[cr + k - 1][cc + i] == 0) {
				return false;
			}
		}
		return true;
	}

	static void cover(int cr, int cc, int k, int f) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				map[cr + i][cc + j] = f;
			}
		}
	}

	static void solve(int cr, int count) {
		if (min != -1 && count >= min) {
			return;
		}

		for (int i = cr; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					for (int k = 1; k <= 5; k++) {
						if (check(i, j, k)) {
							if (type[k] < 5) {
								cover(i, j, k, 0);
								type[k]++;
								solve(i, count + 1);
								cover(i, j, k, 1);
								type[k]--;
							}
						} else {
							return;
						}
					}
				}

				if (i + j == 2 * 9 && (min == -1 || count < min)) {
					min = count;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0);

		System.out.print(min);
	}
}
