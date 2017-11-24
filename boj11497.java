/*
 * 통나무 건너뛰기
 * https://www.acmicpc.net/problem/11497
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj11497 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int[] numbers = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				numbers[i] = sc.nextInt();
			}
			Arrays.sort(numbers);
			int max = 0;
			for (int i = 1; i <= N - 2; i++) {
				max = Math.max(max, numbers[i + 2] - numbers[i]);
			}
			System.out.println(max);
		}
	}
}
