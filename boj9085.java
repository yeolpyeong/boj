/*
 * 더하기
 * https://www.acmicpc.net/problem/9085
 */

package boj;

import java.util.Scanner;

public class boj9085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int sum = 0;
			while (N-- > 0) {
				sum += sc.nextInt();
			}
			System.out.println(sum);
		}
	}
}
