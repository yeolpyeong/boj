/*
 * 녹색 옷 입은 애가 젤다지?
 * https://www.acmicpc.net/problem/4485 
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj4485 {
	static int N, n;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map = new int[126][126], d = new int[126][126];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				return;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					d[i][j] = Integer.MAX_VALUE;
				}
			}
			boj4485();
			System.out.println("Problem " + ++n + ": " + d[N - 1][N - 1]);
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
				if (d[cx][cy] + map[nx][ny] < d[nx][ny]) {
					d[nx][ny] = d[cx][cy] + map[nx][ny];
					q.add(new int[] { nx, ny });
				}
			}
		}
	}
}
