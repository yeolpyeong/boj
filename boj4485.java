/*
 * 녹색 옷 입은 애가 젤다지?
 * https://www.acmicpc.net/problem/4485 
 */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj4485 {
	static int N, n = 0;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map, d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			N = sc.nextInt();
			if (N == 0)
				return;
			map = new int[N][N];
			d = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					d[i][j] = Integer.MAX_VALUE;
				}
			}
			boj4485();

			n++;
			System.out.println("Problem " + n + ": " + d[N - 1][N - 1]);
		}
	}

	public static void boj4485() {
		int cx = 0, cy = 0, nx = 0, ny = 0;
		d[cx][cy] = map[cx][cy];

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { cx, cy });
		while (!q.isEmpty()) {
			int[] l = q.poll();
			cx = l[0];
			cy = l[1];

			for (int i = 0; i < 4; i++) {
				nx = cx + dx[i];
				ny = cy + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (d[nx][ny] > d[cx][cy] + map[nx][ny]) {
					d[nx][ny] = d[cx][cy] + map[nx][ny];
					q.add(new int[] { nx, ny });
				}
			}
		}
	}
}