/*
 * 나이트의 이동
 * https://www.acmicpc.net/problem/7562
 */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7562 {
	static int l, ox, oy;
	static int[] dx = { 1, 1, 2, 2, -1, -1, -2, -2 };
	static int[] dy = { 2, -2, 1, -1, 2, -2, 1, -1 };
	static int[][] visited;
	static Queue<point> q;

	static class point {
		int x;
		int y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			l = sc.nextInt();
			int[][] chessboard = new int[l][l];
			int cx = sc.nextInt();
			int cy = sc.nextInt();
			ox = sc.nextInt();
			oy = sc.nextInt();

			visited = new int[l][l];
			System.out.println(solution(cx, cy, 0));
		}
	}

	public static int solution(int x, int y, int count) {
		q = new LinkedList();
		q.add(new point(x, y));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 1; s <= size; s++) {
				point temp = q.poll();
				int cx = temp.x;
				int cy = temp.y;

				if (cx == ox && cy == oy)
					return count;

				for (int d = 0; d < 8; d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];

					if (!checkRange(nx, ny))
						continue;

					if (visited[nx][ny] == 0) {
						q.add(new point(nx, ny));
						visited[nx][ny] = 1;
					}
				}
			}
			count++;
		}
		return count;
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && y >= 0 && x < l && y < l;
	}
}
