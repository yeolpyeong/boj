/*
 * 최소공배수
 * https://www.acmicpc.net/problem/1934
 */

package boj;

import java.util.Scanner;

public class boj1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(A * B / gcd(A, B));
		}
	}

	public static int gcd(int A, int B) {
		return B != 0 ? gcd(B, A % B) : A;
	}
}
