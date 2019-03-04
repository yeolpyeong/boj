
/*
 * Çà·Ä Á¦°ö
 * https://www.acmicpc.net/problem/10830
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj10830 {
	static int N;

	static int[][] matrixMultiplication(int[][] A, int[][] B) {
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += A[i][k] * B[k][j];
				}
				res[i][j] %= 1000;
			}
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int[][] mat = new int[N][N];
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
			res[i][i] = 1;
		}

		while (B > 0) {
			if (B % 2 == 1) {
				res = matrixMultiplication(res, mat);
			}
			mat = matrixMultiplication(mat, mat);
			B /= 2;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
