/*
 * 콘테스트
 * https://www.acmicpc.net/problem/5576
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj5576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] W = new int[10];
		for (int i = 0; i < 10; i++) {
			W[i] = sc.nextInt();
		}
		Arrays.sort(W);

		int[] K = new int[10];
		for (int i = 0; i < 10; i++) {
			K[i] = sc.nextInt();
		}
		Arrays.sort(K);

		System.out.print((W[7] + W[8] + W[9]) + " " + (K[7] + K[8] + K[9]));
	}
}
