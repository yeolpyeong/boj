/*
 * 보물
 * https://www.acmicpc.net/problem/1026
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		Arrays.sort(B);

		int S = 0;
		for (int i = 0; i < N; i++) {
			S += A[i] * B[N - i - 1];
		}
		System.out.print(S);
	}
}
