
/*
 * 퇴사
 * https://www.acmicpc.net/problem/14501
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj14501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] memoi = new int[N + 2];
		for (int i = N; i >= 1; i--) {
			int gain = 0;
			if (i + T[i] <= N + 1) {
				gain = memoi[i + T[i]] + P[i];
			}
			memoi[i] = Math.max(memoi[i + 1], gain);
		}

		System.out.print(memoi[1]);
	}
}
