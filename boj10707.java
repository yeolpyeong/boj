/*
 * 수도요금
 * https://www.acmicpc.net/problem/10707
 */

package boj;

import java.util.Scanner;

public class boj10707 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int P = sc.nextInt();
		System.out.print(Math.min(A * P, P < C ? B : B + (P - C) * D));
	}
}
