
/*
 * 외판원 순회
 * https://www.acmicpc.net/problem/2098
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class boj2098 {
	static final int INF = 987654321;

	static int N;
	static int[][] W, memoi;

	static int dp(int current, int visited) {
		if (visited == (1 << N) - 1) {
			if (W[current][0] > 0) {
				return W[current][0];
			} else {
				return INF;
			}
		}

		if (memoi[current][visited] != INF) {
			return memoi[current][visited];
		}

		int min = INF;
		for (int next = 0; next < N; next++) {
			if (W[current][next] == 0 || (visited & (1 << next)) != 0) {
				continue;
			}

			min = Math.min(min, dp(next, visited | (1 << next)) + W[current][next]);
		}

		return memoi[current][visited] = min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		memoi = new int[N][1 << N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(memoi[i], INF);
		}

		System.out.print(dp(0, 1));
	}
}
