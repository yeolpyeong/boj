/*
 * 점수 집계
 * https://www.acmicpc.net/problem/9076
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj9076 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int[] score = new int[5];
			for (int i = 0; i < 5; i++) {
				score[i] = sc.nextInt();
			}
			Arrays.sort(score);
			if (score[3] - score[1] >= 4) {
				System.out.println("KIN");
			} else {
				System.out.println(score[1] + score[2] + score[3]);
			}
		}
	}
}
