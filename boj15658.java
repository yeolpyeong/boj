
/*
 * 연산자 끼워넣기 (2)
 * https://www.acmicpc.net/problem/15658
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class boj15658 {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] A, operator;

	static void calculate(int n, int res, int plus, int minus, int multiply, int divide) {
		if (n == N) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}

		if (plus < operator[0]) {
			calculate(n + 1, res + A[n], plus + 1, minus, multiply, divide);
		}
		if (minus < operator[1]) {
			calculate(n + 1, res - A[n], plus, minus + 1, multiply, divide);
		}
		if (multiply < operator[2]) {
			calculate(n + 1, res * A[n], plus, minus, multiply + 1, divide);
		}
		if (divide < operator[3]) {
			calculate(n + 1, res / A[n], plus, minus, multiply, divide + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		calculate(1, A[0], 0, 0, 0, 0);

		System.out.print(max + "\n" + min);
	}
}
