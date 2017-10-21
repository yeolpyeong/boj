/*
 * 부분집합의 합
 * https://www.acmicpc.net/problem/1182
 */

package boj;

import java.util.Scanner;

public class boj1182 {
	static int N, S, count, sum;
	static int[] d = new int[21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();

		for (int i = 1; i <= N; i++)
			d[i] = sc.nextInt();

		boj1182(1);
		System.out.println(count);
	}

	public static void boj1182(int n) {
		if (n > N)
			return;

		if (sum + d[n] == S)
			count++;

		boj1182(n + 1);
		sum += d[n];
		boj1182(n + 1);
		sum -= d[n];
	}
}
