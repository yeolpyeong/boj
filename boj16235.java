
/*
 * 나무 재테크
 * https://www.acmicpc.net/problem/16235
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class boj16235 {
	static final int[] dx = { 1, 1, 1, -1, -1, -1, 0, 0 }, dy = { 1, 0, -1, 1, 0, -1, 1, -1 };

	static int N;
	static int[][] A, nutrient, dead;
	static ArrayList<Integer>[][] map;

	static void spring() {
		dead = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j].size() > 0) {
					Collections.sort(map[i][j]);
					for (int k = 0; k < map[i][j].size(); k++) {
						int temp = map[i][j].get(k);
						if (nutrient[i][j] >= temp) {
							nutrient[i][j] -= temp;
							map[i][j].set(k, temp + 1);
						} else {
							map[i][j].remove(k);
							k--;
							dead[i][j] += temp / 2;
						}
					}
				}
			}
		}
	}

	static void summer() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				nutrient[i][j] += dead[i][j];
			}
		}
	}

	static void fall() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k < map[i][j].size(); k++) {
					if (map[i][j].get(k) % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							if (i + dx[d] >= 1 && j + dy[d] >= 1 && i + dx[d] <= N && j + dy[d] <= N) {
								map[i + dx[d]][j + dy[d]].add(1);
							}
						}
					}
				}
			}
		}
	}

	static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				nutrient[i][j] += A[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		A = new int[N + 1][N + 1];
		map = new ArrayList[N + 1][N + 1];
		nutrient = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new ArrayList<>();
				nutrient[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[x][y].add(z);
		}

		while (K-- > 0) {
			spring();
			summer();
			fall();
			winter();
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				count += map[i][j].size();
			}
		}

		System.out.print(count);
	}
}
