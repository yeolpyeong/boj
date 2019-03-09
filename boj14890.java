
/*
 * °æ»ç·Î 
 * https://www.acmicpc.net/problem/14890
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj14890 {
	static int L, count;

	static int[][] rotate(int[][] map) {
		int N = map.length;
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[N - 1 - j][i];
			}
		}
		return copy;
	}

	static void construct(int[][] map) {
		int N = map.length;
		for (int r = 0; r < N; r++) {
			boolean flag = true;
			int l = 1;
			for (int i = 0; i < N - 1; i++) {
				int diff = map[r][i] - map[r][i + 1];

				if (diff < -1 || diff > 1) {
					flag = false;
					break;
				}

				if (diff > 0) {
					if (i + L < N) {
						i++;
						double sum = 0;
						for (int j = 0; j < L; j++) {
							sum += map[r][i + j];
						}

						if (sum / L != map[r][i]) {
							flag = false;
							break;
						}

						i += L - 2;
						l = 0;
					} else {
						flag = false;
						break;
					}
				} else if (diff < 0) {
					if (l < L) {
						flag = false;
						break;
					} else {
						l = 1;
					}
				} else {
					l++;
				}
			}

			if (flag) {
				count++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		construct(map);
		construct(rotate(map));

		System.out.print(count);
	}
}
