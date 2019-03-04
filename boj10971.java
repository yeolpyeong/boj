
/*
 * 외판원 순회 2
 * https://www.acmicpc.net/problem/10971
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj10971 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] W;
	static boolean[] visited;

	static void dfs(int here, int depth, int cost) {
		if (depth == N && W[here][0] != 0) {
			min = Math.min(min, cost + W[here][0]);
			return;
		}

		for (int there = 0; there < N; there++) {
			if (W[here][there] == 0 || visited[there]) {
				continue;
			}

			visited[there] = true;
			dfs(there, depth + 1, cost + W[here][there]);
			visited[there] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N];
		visited[0] = true;
		dfs(0, 1, 0);

		System.out.print(min);
	}
}
