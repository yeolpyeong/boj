/*
 * 숫자의 개수
 * https://www.acmicpc.net/problem/2577
 */

package boj;

import java.util.Scanner;

public class boj2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int res = A * B * C;
		int[] numbers = new int[10];
		while (res > 0) {
			numbers[res % 10]++;
			res /= 10;
		}
		for (int n : numbers) {
			System.out.println(n);
		}
	}
}
