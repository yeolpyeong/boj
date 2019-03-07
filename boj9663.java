
/*
 * N-Queen
 * https://www.acmicpc.net/problem/9663
 */

import java.util.Scanner;

class boj9663 {
	static int N, count;
	static int[] cols;

	static boolean promising(int l) {
		for (int i = 0; i < l; i++) {
			if (cols[i] == cols[l]) {
				return false;
			}

			if (l - i == Math.abs(cols[l] - cols[i])) {
				return false;
			}
		}

		return true;
	}

	static void dfs(int l) {
		if (l == N) {
			count++;
			return;
		} else {
			for (int i = 0; i < N; i++) {
				cols[l] = i;
				if (promising(l)) {
					dfs(l + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cols = new int[N];

		dfs(0);

		System.out.print(count);
	}
}
