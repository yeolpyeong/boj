/*
 * ¼¼ ¼ö
 * https://www.acmicpc.net/problem/10817
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[3];
		for (int i = 0; i < 3; i++) {
			numbers[i] = sc.nextInt();
		}
		Arrays.sort(numbers);
		System.out.print(numbers[1]);
	}
}
