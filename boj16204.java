/*
 * 카드 뽑기
 * https://www.acmicpc.net/problem/16204
 */

package boj;

import java.util.Scanner;

public class boj16204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		System.out.print(Math.min(M, K) + Math.min(N - M, N - K));
	}
}
