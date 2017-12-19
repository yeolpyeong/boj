/*
 * 초콜릿 자르기
 * https://www.acmicpc.net/problem/2163
 */

package boj;

import java.util.Scanner;

public class boj2163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		System.out.print(N*M - 1);
	}
}
