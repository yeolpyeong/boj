
/*
 * 행렬 곱셈
 * https://www.acmicpc.net/problem/2740
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj2740 {
	static int N, M, K;

	static int[][] matrixMultiplication(int[][] A, int[][] B) {
		int[][] res = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int k = 0; k < M; k++) {
					res[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] B = new int[M][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] res = matrixMultiplication(A, B);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
