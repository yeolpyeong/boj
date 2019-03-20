
/*
 * ¹ì
 * https://www.acmicpc.net/problem/3190
 */

import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;

class boj3190 {
	static final int BLANK = 0, SNAKE = 1, APPLE = 2;
	static final int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, d, second;
	static int[][] map;

	static boolean go(Deque<Point> dq, int X, String C) {
		while (X-- > 0) {
			second++;
			int cx = dq.peekFirst().x;
			int cy = dq.peekFirst().y;
			int nx = cx + dx[d];
			int ny = cy + dy[d];

			if (nx < 1 || ny < 1 || nx > N || ny > N) {
				return false;
			}

			if (map[nx][ny] == SNAKE) {
				return false;
			}

			dq.addFirst(new Point(nx, ny));
			if (map[nx][ny] == APPLE) {
				map[nx][ny] = SNAKE;
				continue;
			}
			map[nx][ny] = SNAKE;
			map[dq.peekLast().x][dq.peekLast().y] = BLANK;
			dq.pollLast();
		}

		if (C.equals("L")) {
			d = (d + 3) % 4;
		} else if (C.equals("D")) {
			d = (d + 1) % 4;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N + 1][N + 1];
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = APPLE;
		}
		Deque<Point> dq = new LinkedList<>();
		dq.add(new Point(1, 1));
		map[1][1] = SNAKE;
		int L = Integer.parseInt(br.readLine());
		boolean end = false;
		while (L-- > 0) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();

			X -= second;
			if (!go(dq, X, C)) {
				end = true;
				break;
			}
		}
		if (!end) {
			go(dq, N, "L");
		}

		System.out.print(second);
	}
}
