
/*
 * 그림
 * https://www.acmicpc.net/problem/1926
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1926 {
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] > 0) {
					++count;
					q.add(500 * i + j);
					map[i][j] = -1;
					int size = 1;
					while (!q.isEmpty()) {
						int cx = q.peek() / 500;
						int cy = q.peek() % 500;
						q.poll();

						for (int d = 0; d < 4; ++d) {
							int nx = cx + dx[d];
							int ny = cy + dy[d];

							if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
								continue;
							}

							if (map[nx][ny] > 0) {
								q.add(500 * nx + ny);
								map[nx][ny] = -1;
								++size;
							}
						}
					}
					if (max < size) {
						max = size;
					}
				}
			}
		}

		System.out.print(count + "\n" + max);
	}
}
