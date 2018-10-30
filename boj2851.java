/*
 * 슈퍼 마리오
 * https://www.acmicpc.net/problem/2851
 */

package boj;

import java.util.Scanner;

public class boj2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] score = new int[11];
		for (int i = 1; i <= 10; i++) {
			score[i] += score[i - 1] + sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 1; i <= 10; i++) {
			if (Math.abs(score[i]-100) <= min) {
				min = Math.abs(score[i]-100);
				index = i;
			}
		}
		System.out.print(score[index]);
	}
}
