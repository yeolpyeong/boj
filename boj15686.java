
/*
 * 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class boj15686 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int M, dist = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Point> houseMap, chickenMap;

	static int calculateDistance(Stack<Integer> stack) {
		int sum = 0;
		for (Point h : houseMap) {
			int min = Integer.MAX_VALUE;
			int hx = h.x;
			int hy = h.y;
			for (int s : stack) {
				int cx = chickenMap.get(s).x;
				int cy = chickenMap.get(s).y;
				int xd = Math.abs(hx - cx);
				int yd = Math.abs(hy - cy);
				min = Math.min(min, xd + yd);
			}
			sum += min;
		}

		return sum;
	}

	static void dfs(Stack<Integer> stack, int idx) {
		if (stack.size() == M) {
			dist = Math.min(dist, calculateDistance(stack));
			return;
		}

		if (idx == chickenMap.size()) {
			return;
		}

		stack.push(idx);
		dfs(stack, idx + 1);
		stack.pop();
		dfs(stack, idx + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		houseMap = new ArrayList<>();
		chickenMap = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					houseMap.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chickenMap.add(new Point(i, j));
				}
			}
		}

		Stack<Integer> stack = new Stack<>();
		dfs(stack, 0);

		System.out.print(dist);
	}
}
