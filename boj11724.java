/*
 * 연결 요소의 개수
 * https://www.acmicpc.net/problem/11724
 */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj11724 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] adj = new int[N + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[x][y] = adj[y][x] = 1;
		}

		boolean[] visited = new boolean[N + 1];
		int connectedComponent = 0;
		Queue<Integer> q = new LinkedList();
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;

			q.add(i);
			connectedComponent++;
			while (!q.isEmpty()) {
				int x = q.poll();
				for (int y = 1; y <= N; y++) {
					if (adj[x][y] == 1 && !visited[y]) {
						q.add(y);
						visited[y] = true;
					}
				}
			}
		}
		System.out.print(connectedComponent);
	}
}
