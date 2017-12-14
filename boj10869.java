/*
 * 사칙연산 
 * https://www.acmicpc.net/problem/10869
 */

package boj;

import java.util.Scanner;

public class boj10869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(A + B);
		System.out.println(A - B);
		System.out.println(A * B);
		System.out.println(A / B);
		System.out.println(A % B);
	}
}
