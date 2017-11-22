/*
 * 침투
 * https://www.acmicpc.net/problem/13565
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13565 {
	static int M, N, percolate;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			String row = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = row.charAt(j - 1) == '0' ? 0 : 1;
			}
		}

		for (int i = 1; i <= N; i++) {
			boj13565(1, i);
		}

		System.out.print(percolate == 1 ? "YES" : "NO");
	}

	public static void boj13565(int x, int y) {
		if (x == M) {
			percolate = 1;
			return;
		}

		if (!checkRange(x, y) || map[x][y] != 0)
			return;

		map[x][y] = 1;
		boj13565(x + 1, y);
		boj13565(x - 1, y);
		boj13565(x, y + 1);
		boj13565(x, y - 1);
	}

	public static boolean checkRange(int x, int y) {
		return x > 0 && y > 0 && x <= M && y <= N;
	}
}
