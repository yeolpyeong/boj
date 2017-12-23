/*
 * ¹Ý¿Ã¸²
 * https://www.acmicpc.net/problem/2033
 */

package boj;

import java.util.Scanner;

public class boj2033 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = String.valueOf(N).length();
		for (int i = 2; i <= P; i++) {
			N = (int) (Math.round(N / Math.pow(10, i - 1)) * Math.pow(10, i - 1));
		}
		System.out.print(N);
	}
}
