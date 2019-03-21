
/*
 * 스타트와 링크
 * https://www.acmicpc.net/problem/14889
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj14889 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] S;

	static int scoring(int[] g) {
		int s1 = 0, s2 = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (g[i] + g[j] == 0) {
					s1 += S[i][j] + S[j][i];
				}
				if (g[i] + g[j] == 2) {
					s2 += S[i][j] + S[j][i];
				}
			}
		}
		return Math.abs(s1 - s2);
	}

	static void dfs(int[] g, int n, int m) {
		if (n == N / 2) {
			min = Math.min(min, scoring(g));
			return;
		}

		for (int i = m; i <= N; i++) {
			if (g[i] == 0) {
				g[i]++;
				dfs(n + 1, i, g);
				g[i]--;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		S = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(new int[N + 1], 0, 1);

		System.out.print(min);
	}
}
