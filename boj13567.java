/*
 * 로봇
 * https://www.acmicpc.net/problem/13567
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13567 {
	static int M, d, x, y;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] map = new int[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			boj13567(st.nextToken(), Integer.parseInt(st.nextToken()));
			if (!checkRange(x, y)) {
				System.out.print(-1);
				return;
			}
		}
		System.out.print(x + " " + y);
	}

	public static void boj13567(String order, int n) {
		if (order.equals("MOVE")) {
			x += n * dx[d];
			y += n * dy[d];
		}

		if (order.equals("TURN")) {
			if (n == 0) {
				d = (d + 3) % 4;
			} else if (n == 1) {
				d = (d + 1) % 4;
			}
		}
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && y >= 0 && x <= M && y <= M;
	}
}
