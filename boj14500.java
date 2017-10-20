/*
 * 테크로미노
 * https://www.acmicpc.net/problem/14500
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500 {
	static int N, M, res = Integer.MIN_VALUE;
	static int[][] map = new int[501][501], v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				boj14500(i, j);
			}
		}
		System.out.println(res);
	}

	public static void boj14500(int x, int y) {
		int temp;
		if (checkRange(x, y + 3)) {
			temp = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x][y + 3];
			res = temp > res ? temp : res;
		}
		if (checkRange(x + 3, y)) {
			temp = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 3][y];
			res = temp > res ? temp : res;
		}
		if (checkRange(x + 1, y + 1)) {
			temp = map[x][y] + map[x + 1][y] + map[x][y + 1] + map[x + 1][y + 1];
			res = temp > res ? temp : res;
		}
		if (checkRange(x + 1, y + 2)) {
			temp = map[x][y] + map[x + 1][y] + map[x][y + 1] + map[x][y + 2];
			res = temp > res ? temp : res;
			temp = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 2];
			res = temp > res ? temp : res;
			temp = map[x + 1][y] + map[x + 1][y + 1] + map[x][y + 2] + map[x + 1][y + 2];
			res = temp > res ? temp : res;
			temp = map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 1][y + 2];
			res = temp > res ? temp : res;
			temp = map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 1][y + 2];
			res = temp > res ? temp : res;
			temp = map[x + 1][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x][y + 2];
			res = temp > res ? temp : res;
			temp = map[x + 1][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 1][y + 2];
			res = temp > res ? temp : res;
			temp = map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x][y + 2];
			res = temp > res ? temp : res;
		}
		if (checkRange(x + 2, y + 1)) {
			temp = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 2][y + 1];
			res = temp > res ? temp : res;
			temp = map[x + 2][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1];
			res = temp > res ? temp : res;
			temp = map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1];
			res = temp > res ? temp : res;
			temp = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x][y + 1];
			res = temp > res ? temp : res;
			temp = map[x + 1][y] + map[x + 2][y] + map[x][y + 1] + map[x + 1][y + 1];
			res = temp > res ? temp : res;
			temp = map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 2][y + 1];
			res = temp > res ? temp : res;
			temp = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1];
			res = temp > res ? temp : res;
			temp = map[x + 1][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1];
			res = temp > res ? temp : res;
		}
	}

	public static boolean checkRange(int x, int y) {
		return x > 0 && y > 0 && x <= N && y <= M;
	}
}
