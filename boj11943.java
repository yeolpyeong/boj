/*
 * 파일 옮기기
 * https://www.acmicpc.net/problem/11943
 */

package boj;

import java.util.Scanner;

public class boj11943 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		System.out.print(Math.min(A + D, B + C));
	}
}
