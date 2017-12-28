/*
 * ¹æ ¹øÈ£
 * https://www.acmicpc.net/problem/1475
 */

package boj;

import java.util.Scanner;

public class boj1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numbers = new int[10];
		for (int i = 0; i < String.valueOf(N).length(); i++) {
			numbers[(int) String.valueOf(N).charAt(i) - '0']++;
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
