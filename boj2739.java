/*
 * 구구단
 * https://www.acmicpc.net/problem/2739
 */

package boj;

import java.util.Scanner;

public class boj2739 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.println(N + " * " + i + " = " + N * i);
		}
	}
}
