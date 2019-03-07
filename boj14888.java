
/*
 * 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 */

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

class boj14888 {
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] A;

	static void calculate(ArrayList<Integer> operator) {
		int res = A[0];
		for (int i = 1; i < A.length; i++) {
			int op = operator.get(i - 1);
			if (op == 0) {
				res += A[i];
			} else if (op == 1) {
				res -= A[i];
			} else if (op == 2) {
				res *= A[i];
			} else if (op == 3) {
				res /= A[i];
			}
		}

		max = Math.max(max, res);
		min = Math.min(min, res);
	}

	static void swap(ArrayList<Integer> array, int i, int j) {
		int temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}

	static void perm(ArrayList<Integer> array, int pivot) {
		if (pivot == array.size() - 1) {
			calculate(array);
			return;
		}

		for (int i = pivot; i < array.size(); i++) {
			swap(array, i, pivot);
			perm(array, pivot + 1);
			swap(array, i, pivot);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> operator = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int temp = Integer.parseInt(st.nextToken());
			while (temp-- > 0) {
				operator.add(i);
			}
		}

		perm(operator, 0);

		System.out.print(max + "\n" + min);
	}
}
