
/*
 * 미로 만들기
 * https://www.acmicpc.net/problem/1347
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj1347 {
	static final int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String M = sc.next();
		ArrayList<Integer> X = new ArrayList<>();
		ArrayList<Integer> Y = new ArrayList<>();
		ArrayList<Point> points = new ArrayList<>();
		X.add(0);
		Y.add(0);
		points.add(new Point(0, 0));
		int point = 0, direction = 0;
		for (int i = 0; i < N; i++) {
			if (M.charAt(i) == 'R') {
				direction = (direction + 1) % 4;
			} else if (M.charAt(i) == 'L') {
				direction = (direction + 3) % 4;
			} else if (M.charAt(i) == 'F') {
				int x = X.get(point) + dx[direction];
				int y = Y.get(point) + dy[direction];
				X.add(x);
				Y.add(y);
				points.add(new Point(x, y));
				point++;
			}
		}

		Collections.sort(X);
		Collections.sort(Y);
		int h = 1 + (X.get(X.size() - 1) - X.get(0));
		int w = 1 + (Y.get(Y.size() - 1) - Y.get(0));
		boolean[][] maze = new boolean[h][w];
		for (Point p : points) {
			if (X.get(0) < 0) {
				p.x -= X.get(0);
			}
			if (Y.get(0) < 0) {
				p.y -= Y.get(0);
			}

			maze[p.x][p.y] = true;
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(maze[i][j] ? '.' : '#');
			}
			System.out.println();
		}
	}
}
