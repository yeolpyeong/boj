/*
 * 방 번호
 * https://www.acmicpc.net/problem/1475
 */

package boj;

import java.util.Scanner;

public class boj1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int[] numbers = new int[10];
		for (int i = 0; i < N.length(); i++) {
			numbers[(int) N.charAt(i) - '0']++;
		}
		numbers[6] = (int) Math.ceil((double) (numbers[6] + numbers[9]) / 2);
		int max = 0;
		for (int i = 0; i <= 8; i++) {
			if (numbers[i] > max)
				max = numbers[i];
		}
		System.out.print(max);
	}
}
