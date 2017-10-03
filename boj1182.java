/*
 * 부분집합의 합
 * https://www.acmicpc.net/problem/1182
 */

package boj;

import java.util.Scanner;

public class boj1182 {
	static int N, S, c = 0, res = 0;
	static int[] d = new int[21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();

		for (int i = 1; i <= N; i++)
			d[i] = sc.nextInt();

		baekjoon1182(1);
		System.out.println(c);
	}

	public static void baekjoon1182(int n) {
		if (n > N)
			return;

		if (res + d[n] == S)
			c++;

		baekjoon1182(n + 1);

		res += d[n];
		baekjoon1182(n + 1);

		res -= d[n];
	}
}
