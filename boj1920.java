
/*
 * ¼ö Ã£±â
 * https://www.acmicpc.net/problem/1920
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class boj1920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] numbers = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		for (int i : numbers) {
			int flag = 0;
			int max = N;
			int min = -1;
			int middle;
			while (max - min > 1) {
				middle = (max + min) / 2;
				if (i > A[middle]) {
					min = middle;
				} else if (i < A[middle]) {
					max = middle;
				} else {
					flag = 1;
					break;
				}
			}

			System.out.println(flag);
		}
	}
}
