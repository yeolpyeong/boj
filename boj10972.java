
/*
 * 다음 순열
 * https://www.acmicpc.net/problem/10972
 */

import java.util.Scanner;

class boj10972 {
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static void reverse(int[] array, int begin, int end) {
		end--;
		while (begin < end) {
			swap(array, begin++, end--);
		}
	}

	static boolean nextPermutation(int[] array, int begin, int end) {
		if (begin == end) {
			return false;
		}

		if (begin == end -1) {
			return false;
		}

		int i = end - 1;
		while (true) {
			int j = i--;
			
			if (array[i] < array[j]) {
				int k = end;
				while (!(array[i] < array[--k])) {
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

		if (nextPermutation(perm, 0, N)) {
			for (int i = 0; i < N; i++) {
				System.out.print(perm[i] + " ");
			}
		} else {
			System.out.print(-1);
		}
	}
}