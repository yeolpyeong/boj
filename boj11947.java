/*
 * 이런 반전이
 * https://www.acmicpc.net/problem/11947
 */

package boj;

import java.util.Scanner;

public class boj11947 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int center = (int) Math.pow(10, String.valueOf(N).length()) / 2;
			N = Math.min(N, center);
			long Fn = (long) (Math.pow(10, String.valueOf(N).length()) - 1) - N;
			System.out.println(N * Fn);
		}
	}
}
