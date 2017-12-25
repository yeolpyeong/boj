/*
 * 시험 점수
 * https://www.acmicpc.net/problem/5596
 */

package boj;

import java.util.Scanner;

public class boj5596 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 1; i <= 4; i++) {
			sum1 += sc.nextInt();
		}
		for (int i = 1; i <= 4; i++) {
			sum2 += sc.nextInt();
		}
		System.out.print(Math.max(sum1, sum2));
	}
}
