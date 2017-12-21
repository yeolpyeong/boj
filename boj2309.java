/*
 * 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			numbers[i] = sc.nextInt();
			sum += numbers[i];
		}
		Arrays.sort(numbers);
		sum -= 100;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (numbers[i] + numbers[j] == sum) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j)
							System.out.println(numbers[k]);
					}
					return;
				}
			}
		}
	}
}
