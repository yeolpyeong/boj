/*
 * A+B - 5
 * https://www.acmicpc.net/problem/10952
 */

package boj;

import java.util.Scanner;

public class boj10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if (A == 0 && B == 0) {
				break;
			} else {
				System.out.println(A + B);
			}
		}
	}
}
