/*
 * POT 
 * https://www.acmicpc.net/problem/11772
 */

package boj;

import java.util.Scanner;

public class boj11772 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			int P = sc.nextInt();
			sum += (int) Math.pow(P / 10, P % 10);
		}
		System.out.print(sum);
	}
}
