/*
 * 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 */

package boj;

import java.util.Scanner;

public class boj14888 {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		int[] OP = new int[5];
		for (int i = 1; i <= 4; i++) {
			OP[i] = sc.nextInt();
		}

		boj14888(1, OP, A[1]);
		System.out.print(max + "\n" + min);
	}

	public static void boj14888(int depth, int[] op, int res) {
		if (depth == N) {
			max = Math.max(max, res);
			min = Math.min(min, res);
		} else {
			for (int i = 1; i <= 4; i++) {
				if (op[i] != 0) {
					int calc = calculation(depth, i, res);
					op[i]--;
					boj14888(depth + 1, op, calc);
					op[i]++;
				}
			}
		}
	}

	public static int calculation(int depth, int operator, int res) {
		switch (operator) {
		case 1:
			res += A[depth + 1];
			break;
		case 2:
			res -= A[depth + 1];
			break;
		case 3:
			res *= A[depth + 1];
			break;
		case 4:
			res /= A[depth + 1];
			break;
		}
		return res;
	}
}
