/*
 * 방학 숙제
 * https://www.acmicpc.net/problem/5532
 */

package boj;

import java.util.Scanner;

public class boj5532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		double A = sc.nextInt();
		double B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		System.out.print(L - (int) Math.ceil(Math.max(A / C, B / D)));
	}
}
