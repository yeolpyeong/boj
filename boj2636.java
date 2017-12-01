/*
 * 치즈
 * https://www.acmicpc.net/problem/2636
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2636 {
	static int N, M, t, nMeltingCheese, nRemainingCheese;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map = new int[101][101], airMap;

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

		boj2636();
		System.out.println(t);
		System.out.println(nRemainingCheese);
	}

	public static void boj2636() {
		while (true) {
			nMeltingCheese = 0;
			airMap = new int[N + 1][M + 1];
			fillAir(1, 1);

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j] == 1 && checkMeltingCheese(i, j)) {
						map[i][j] = 0;
						nMeltingCheese++;
					}
				}
			}
			
			if (nMeltingCheese == 0) {
				break;
			} else {
				nRemainingCheese = nMeltingCheese;
			}
			t++;
		}
	}

	public static void fillAir(int x, int y) {
		if (!checkRange(x, y))
			return;

		if (map[x][y] == 0 && airMap[x][y] == 0) {
			airMap[x][y] = -1;
			for (int i = 0; i < 4; i++) {
				fillAir(x + dx[i], y + dy[i]);
			}
		}
	}

	public static boolean checkRange(int x, int y) {
		return x >= 1 && y >= 1 && x <= N && y <= M;
	}

	public static boolean checkMeltingCheese(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!checkRange(nx, ny))
				return false;
			
			if (airMap[nx][ny] == -1) {
				return true;
			}
		}
		return false;
	}
}
