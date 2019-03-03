/*
 * 이전 순열
 * https://www.acmicpc.net/problem/10973
 */

import java.util.Scanner;

class boj10973 {
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	static void reverse(int[] array, int begin, int end) {
		end--;
		while (begin < end) {
			swap(array, begin++, end--);
		}
	}

	static boolean perviousPermutation(int[] array, int begin, int end) {
		if (begin == end) {
			return false;
		}

		if (begin == end - 1) {
			return false;
		}

		int i = end - 1;
		while (true) {
			int j = i--;

			if (array[i] > array[j]) {
				int k = end;
				while (!(array[i] > array[--k])) {
				}
				swap(array, i, k);
				reverse(array, j, end);
				return true;
			}

			if (i == begin) {
				reverse(array, begin, end);
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] perm = new int[N];
		for (int i = 0; i < N; i++) {
			perm[i] = sc.nextInt();
		}

		if (perviousPermutation(perm, 0, N)) {
			for (int p : perm) {
				System.out.print(p + " ");
			}
		} else {
			System.out.print(-1);
		}
	}
}
