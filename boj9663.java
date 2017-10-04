/*
 * N-Queen
 * https://www.acmicpc.net/problem/9663
 */

package boj;

import java.util.Scanner;

public class boj9663 {
	static int N, res;
	static int[] cols = new int[16];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		boj9663(0);
		System.out.println(res);
	}

	public static boolean boj9663(int l) {
		if (!promising(l))
			return false;
		else if (l == N) {
			res += 1;
			return false;
		} else {
			for (int i = 1; i <= N; i++) {
				cols[l + 1] = i;
				if (boj9663(l + 1))
					return true;
			}
		}
		return false;
	}

	public static boolean promising(int l) {
		for (int i = 1; i < l; i++) {
			if (cols[i] == cols[l])
				return false;
			if (l - i == Math.abs(cols[l] - cols[i]))
				return false;
		}
		return true;
	}
}
