
/*
 * 모든 순열
 * https://www.acmicpc.net/problem/10974
 */

import java.util.Scanner;

public class boj10974 {
	static int N;
	static int[] perm;
	static boolean[] visited;

	public static void dfs(int depth, int index) {
		perm[depth] = index;

		if (depth == N) {
			for (int i = 1; i <= N; i++) {
				System.out.print(perm[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			dfs(depth + 1, i);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		perm = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(1, i);
			visited[i] = false;
		}
	}
}
