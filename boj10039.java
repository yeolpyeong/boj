/*
 * 평균 점수
 * https://www.acmicpc.net/problem/10039
 */

package boj;

import java.util.Scanner;

public class boj10039 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			int score = sc.nextInt();
			sum += score < 40 ? 40 : score;
		}
		System.out.println(sum / 5);
	}
}
