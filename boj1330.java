/*
 * 두 수 비교하기
 * https://www.acmicpc.net/problem/1330
 */

import java.util.Scanner;

class boj1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.print(A > B ? ">" : A < B ? "<" : "==");
	}
}
