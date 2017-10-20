/*
 * 주사위 굴리기
 * https://www.acmicpc.net/problem/14499
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14499 {
	static int N, M;
	static int[] dice = new int[7];
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static int[][] map = new int[20][20];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (K-- > 0) {
			int d = Integer.parseInt(st.nextToken());
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!checkRange(nx, ny))
				continue;
			rollTheDice(d);
			checkMap(nx, ny);
			System.out.println(dice[1]);
			x = nx;
			y = ny;
		}
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
	
	public static void rollTheDice(int d) {
		int temp;
		if (d == 1) {
			temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = temp;
		}
		if (d == 2) {
			temp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = temp;
		}
		if (d == 3) {
			temp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = temp;
		}
		if (d == 4) {
			temp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = temp;
		}
	}

	public static void checkMap(int x, int y) {
		if (map[x][y] == 0) {
			map[x][y] = dice[6];
		} else {
			dice[6] = map[x][y];
			map[x][y] = 0;
		}
	}
}
