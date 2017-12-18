/*
 * 약수 구하기
 * https://www.acmicpc.net/problem/2501
 */

package boj;

import java.util.Scanner;

public class boj2501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int n = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0)
				n++;
			if (n == K) {
				System.out.print(i);
				break;
			}
		}
		if (K > n)
			System.out.print(0);
	}
}
