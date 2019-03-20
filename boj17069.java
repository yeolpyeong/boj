
/*
 * 파이프 옮기기 2
 * https://www.acmicpc.net/problem/17069
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj17069 {
	static long dp(int[][] map) {
		int N = map.length - 1;
		long[][][] memoi = new long[N + 1][N + 1][3];
		memoi[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					continue;
				}

				for (int d = 0; d < 3; d++) {
					if (d != 1 && memoi[i][j - 1][d] > 0) {
						memoi[i][j][0] += memoi[i][j - 1][d];
					}

					if (d != 0 && memoi[i - 1][j][d] > 0) {
						memoi[i][j][1] += memoi[i - 1][j][d];
					}

					if (memoi[i - 1][j - 1][d] > 0 && map[i][j - 1] == 0 && map[i - 1][j] == 0) {
						memoi[i][j][2] += memoi[i - 1][j - 1][d];
					}
				}
			}
		}
		return memoi[N][N][0] + memoi[N][N][1] + memoi[N][N][2];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.print(dp(map));
	}
}
