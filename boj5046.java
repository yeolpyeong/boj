/*
 * 전국 대학생 프로그래밍 대회 동아리 연합
 * https://www.acmicpc.net/problem/5046
 */

package boj;

import java.util.Scanner;

public class boj5046 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		int H = sc.nextInt();
		int W = sc.nextInt();
		int min = 500001;
		for (int i = 1; i <= H; i++) {
			int p = sc.nextInt();
			for (int j = 1; j <= W; j++) {
				int a = sc.nextInt();
				if (a >= N)
					min = Math.min(min, p * N);
			}
		}
		System.out.print(min <= B ? min : "stay home");
	}
}
