
/*
 * 결혼식
 * https://www.acmicpc.net/problem/5567
 */

import java.util.Scanner;

public class boj5567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] adj = new boolean[n + 1][n + 1];
		while (m-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = adj[b][a] = true;
		}

		boolean[] visited = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			if (adj[1][i]) {
				visited[i] = true;
				for (int j = 2; j <= n; j++) {
					if (adj[i][j] || adj[j][i]) {
						visited[j] = true;
					}
				}
			}
		}

		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (visited[i]) {
				count++;
			}
		}

		System.out.print(count);
	}
}
