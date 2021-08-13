/*
 * ≈ª√‚
 * https://www.acmicpc.net/problem/3055
 */

package boj;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class boj3055 {
	static final int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static int R, C, minute, end;
	static char[][] map;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Queue<Point> hedgehog = new LinkedList<>(), flood = new LinkedList<>();

	static void spreadFlood(int size) {
		for (int s = 0; s < size; s++) {
			Point p = flood.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					continue;
				}

				if (map[nr][nc] == '.') {
					map[nr][nc] = '*';
					flood.add(new Point(nr, nc));
				}
			}
		}
	}

	static void goToSeeBeaver(int size) {
		for (int s = 0; s < size; s++) {
			Point p = hedgehog.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					continue;
				}

				if (map[nr][nc] == 'D') {
					end = 1;
					return;
				} else if (map[nr][nc] == '.') {
					map[nr][nc] = 'S';
					hedgehog.add(new Point(nr, nc));
				}
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String temp = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'S') {
					hedgehog.add(new Point(i, j));
				} else if (map[i][j] == '*') {
					flood.add(new Point(i, j));
				}
			}
		}

		while (end == 0 && !hedgehog.isEmpty()) {
			minute++;
			spreadFlood(flood.size());
			goToSeeBeaver(hedgehog.size());
		}

		if (end == 1) {
			System.out.println(minute);
		} else {
			System.out.println("KAKTUS");
		}
	}
}
