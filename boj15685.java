
/*
 * 드래곤 커브
 * https://www.acmicpc.net/problem/15685
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class boj15685 {
	static final int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	static int N;
	static int[][] map = new int[101][101];
	static Stack<Integer> storage1, storage2;
	static Queue<Integer> storage3;

	static void makeDragonCurve() {
		while (!storage1.isEmpty()) {
			int d = storage1.pop();
			storage2.push((d + 1) % 4);
			storage3.add((d + 1) % 4);
		}
		storage1 = (Stack<Integer>) storage2.clone();
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		while (N-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();

			storage1 = new Stack();
			storage2 = new Stack();
			storage3 = new LinkedList();

			storage1.push(d);
			storage2.push(d);
			storage3.add(d);
			while (g-- > 0) {
				makeDragonCurve();
			}

			map[x][y] = 1;
			while (!storage3.isEmpty()) {
				d = storage3.poll();
				x += dx[d];
				y += dy[d];
				map[x][y] = 1;
			}
		}

		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] * map[i + 1][j] * map[i][j + 1] * map[i + 1][j + 1] == 1) {
					count++;
				}
			}
		}
		
		System.out.print(count);
	}
}
