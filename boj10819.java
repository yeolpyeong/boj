
/*
 * 차이를 최대로
 * https://www.acmicpc.net/problem/10819
 */

import java.util.Scanner;

public class boj10819 {
	static int max = Integer.MIN_VALUE;

	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	static void perm(int[] A, int pivot) {
		if (pivot == A.length) {
			int sum = 0;
			for (int i = 0; i < A.length - 1; i++) {
				sum += Math.abs(A[i] - A[i + 1]);
			}

			if (max < sum) {
				max = sum;
			}
			return;
		}

		for (int i = pivot; i < A.length; i++) {
			swap(A, i, pivot);
			perm(A, pivot + 1);
			swap(A, i, pivot);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		perm(A, 0);

		System.out.print(max);
	}
}
