
/*
 * 다음 순열
 * https://www.acmicpc.net/problem/10972
 */

import java.util.Scanner;

class boj16972 {
	static boolean nextPermutation(int[] array, int begin, int end) {
		if (begin == end) {
			return false;
		}

		if (begin + 1 == end) {
			return false;
		}

		int i = end - 1;

		while (true) {
			int j = i - 1;

			if (array[i] < array[j]) {
				int k = end;
				while (!(array[i] < array[--k])) {

				}
			}
			break;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] perm = new int[N];
		for (int i = 0; i < N; i++) {
			perm[i] = sc.nextInt();
		}
		int k = 2;
		System.out.println(perm[k]);
		System.out.println(perm[--k]);
		k = 2;
		System.out.println(perm[k]);
		System.out.println(perm[k--]);

	}
}
