
/*
 * 네 수
 * https://www.acmicpc.net/problem/10824
 */

import java.util.Scanner;

class boj10824 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		String C = sc.next();
		String D = sc.next();

		System.out.print(Long.parseLong(A + B) + Long.parseLong(C + D));
	}
}
