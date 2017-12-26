/*
 * 점수 계산
 * https://www.acmicpc.net/problem/2822
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj2822 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] beforeSorting = new int[8];
		int[] afterSorting = new int[8];
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			beforeSorting[i] = sc.nextInt();
			afterSorting[i] = beforeSorting[i];
			sum += afterSorting[i];
		}
		Arrays.sort(afterSorting);
		System.out.println(sum - afterSorting[0] - afterSorting[1] - afterSorting[2]);
		for (int i = 0; i < 8; i++) {
			if (beforeSorting[i] > afterSorting[2])
				System.out.print(i + 1 + " ");
		}
	}
}
