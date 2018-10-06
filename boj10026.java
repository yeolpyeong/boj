/*
 * 적록색약
 * https://www.acmicpc.net/problem/10026
 */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj10026 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] map1 = new int[N + 1][N + 1];
		int[][] map2 = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String temp = sc.next();
			for (int j = 1; j <= N; j++) {
				map1[i][j] = temp.charAt(j - 1);
				map2[i][j] = temp.charAt(j - 1) % 11;
			}
		}
		System.out.print(solution(map1) + " " + solution(map2));
	}

	public static int solution(int[][] map) {
		int area = 0;
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		class point {
			int x, y;

			public point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		Queue<point> q = new LinkedList();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] >= 0) {
					int color = map[i][j];
					q.add(new point(i, j));
					map[i][j] = -1;
					area++;
					while (!q.isEmpty()) {
						point temp = q.poll();
						int cx = temp.x;
						int cy = temp.y;
						for (int d = 0; d < 4; d++) {
							int nx = cx + dx[d];
							int ny = cy + dy[d];
							if (!checkRange(nx, ny) || map[nx][ny] != color)
								continue;
							q.add(new point(nx, ny));
							map[nx][ny] = -1;
						}
					}
				}
			}
		}
		return area;
	}

	public static boolean checkRange(int x, int y) {
		return x >= 1 && y >= 1 && x <= N && y <= N;
	}
}
