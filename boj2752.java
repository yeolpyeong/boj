/*
 * 세수정렬
 * https://www.acmicpc.net/problem/2752
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj2752 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int[] numbers = { A, B, C };
		Arrays.sort(numbers);
		for (int i : numbers) {
			System.out.print(i + " ");
		}
	}
}
