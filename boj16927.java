
/*
 * 배열 돌리기 2
 * https://www.acmicpc.net/problem/16927
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj16927 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int C = 0;
		while (Math.min(N, M) > 2 * C) {
			int D = R % (2 * (N + M - 4 * C) - 4);
			while (D-- > 0) {
				int temp = array[C][C];
				for (int i = C; i < M - C - 1; i++) {
					array[C][i] = array[C][i + 1];
				}
				for (int i = C; i < N - C - 1; i++) {
					array[i][M - C - 1] = array[i + 1][M - C - 1];
				}
				for (int i = M - C - 1; i > C; i--) {
					array[N - C - 1][i] = array[N - C - 1][i - 1];
				}
				for (int i = N - C - 1; i > C; i--) {
					array[i][C] = array[i - 1][C];
				}
				array[C + 1][C] = temp;
			}
			C++;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
