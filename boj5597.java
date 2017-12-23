/*
 * 과제 안 내신 분..?
 * https://www.acmicpc.net/problem/5597
 */

package boj;

import java.util.Scanner;

public class boj5597 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] students = new int[31];
		for (int i = 1; i <= 28; i++) {
			int n = sc.nextInt();
			students[n]++;
		}
		for (int i = 1; i <= 30; i++) {
			if (students[i] == 0)
				System.out.println(i);
		}
	}
}
