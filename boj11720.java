/*
 * 숫자의 합
 * https://www.acmicpc.net/problem/11720
 */

package boj;

import java.util.Scanner;

public class boj11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String numbers = sc.next();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += numbers.charAt(i) - '0';
		}
		System.out.print(sum);
	}
}
