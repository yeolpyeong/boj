/*
 * 더하기 사이클
 * https://www.acmicpc.net/problem/1110
 */

package boj;

import java.util.Scanner;

public class boj1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int initailNumber = N;
		int count = 0;
		do {
			N = (N % 10) * 10 + (N / 10 + N % 10) % 10;
			count++;
		} while (N != initailNumber);
		System.out.print(count);
	}
}
