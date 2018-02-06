/*
 * 이진수 합
 * https://www.acmicpc.net/problem/8741
 */

package boj;

import java.util.Scanner;

public class boj8741 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= k; i++) {
			sb.append(1);
		}
		for (int i = 1; i < k; i++) {
			sb.append(0);
		}
		System.out.print(sb);
	}
}
