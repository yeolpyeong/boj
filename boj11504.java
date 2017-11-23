/*
 * 돌려 돌려 돌림판!
 * https://www.acmicpc.net/problem/11504
 */

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11504 {
	static int N, M, X, Y;
	static int[] wheel = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			String s = "";
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				s += st.nextToken();
			}
			X = Integer.parseInt(s);

			s = "";
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				s += st.nextToken();
			}
			Y = Integer.parseInt(s);

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				wheel[i] = Integer.parseInt(st.nextToken());
			}

			System.out.println(boj11504());
		}
	}

	public static int boj11504() {
		int n = 0;
		for (int i = 1; i <= N; i++) {
			String s = "";
			for (int j = 1; j <= M; j++) {
				s += wheel[(i + j) % N + 1];
			}
			if (Integer.parseInt(s) >= X && Integer.parseInt(s) <= Y)
				n++;
		}
		return n;
	}
}
