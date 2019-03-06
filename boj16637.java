
/*
 * 괄호 추가하기
 * https://www.acmicpc.net/problem/16637
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class boj16637 {
	static int N, max = Integer.MIN_VALUE;
	static int[] expression;

	static int calculate(int operator, int a, int b) {
		if (operator == '+') {
			return a + b;
		} else if (operator == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

	static void solve(int i, int res) {
		if (i == N) {
			if (res > max) {
				max = res;
			}
			return;
		}

		solve(i + 2, calculate(expression[i], res, expression[i + 1]));
		if (i + 4 <= N) {
			solve(i + 4,
					calculate(expression[i], res, calculate(expression[i + 2], expression[i + 1], expression[i + 3])));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		expression = new int[N];
		String line = br.readLine();
		for (int i = 0; i < N; i++) {
			int temp = line.charAt(i);
			expression[i] = i % 2 == 0 ? temp - '0' : temp;
		}

		int i = 1;
		int res = expression[i - 1];
		solve(i, res);

		System.out.print(max);
	}
}
