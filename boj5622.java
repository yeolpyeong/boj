/*
 * ´ÙÀÌ¾ó
 * https://www.acmicpc.net/problem/5622
 */

package boj;

import java.util.Scanner;

public class boj5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String alphabet = sc.next();
		int[] numbers = { 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10 };
		int sum = 0;
		for (int i = 0; i < alphabet.length(); i++) {
			sum += numbers[(int) alphabet.charAt(i) - 'A'];
		}
		System.out.print(sum);
	}
}
