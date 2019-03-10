
/*
 * ATM
 * https://www.acmicpc.net/problem/11399
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class boj11399 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		Arrays.sort(P);
		for (int i = 0; i < N; i++) {
			sum += (N - i) * P[i];
		}

		System.out.print(sum);
	}
}
