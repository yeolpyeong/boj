/*
 * 시험 감독
 * https://www.acmicpc.net/problem/13458
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj13458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long count = 0;
		for (int i = 0; i < N; i++) {
			A[i] -= B;
			count++;

			if (A[i] > 0) {
				count += A[i] / C;
				count += A[i] % C != 0 ? 1 : 0;
			}
		}

		System.out.print(count);
	}
}
