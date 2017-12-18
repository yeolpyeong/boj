/*
 * ¾à¼ö
 * https://www.acmicpc.net/problem/1037
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] divisors = new int[N];
		for (int i = 0; i < N; i++) {
			divisors[i] = sc.nextInt();
		}
		Arrays.sort(divisors);
		System.out.print(divisors[0] * divisors[N - 1]);
	}
}
