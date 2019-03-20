
/*
 * 공백 없는 A+B
 * https://www.acmicpc.net/problem/15873
 */

import java.util.Scanner;

class boj15873 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int A, B;
		if (N % 10 == 0) {
			A = N / 100;
			B = 10;
		} else {
			A = N / 10;
			B = N % 10;
		}

		System.out.print(A + B);
	}
}
