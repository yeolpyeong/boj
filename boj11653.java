/*
 * 소인수분해
 * https://www.acmicpc.net/problem/11653
 */

package boj;

import java.util.Scanner;

public class boj11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 2; i <= N; i++) {
			if (N % i == 0) {
				System.out.println(i);
				N /= i;
				i--;
			}
		}
	}
}