
/*
 * 이상한 기호
 * https://www.acmicpc.net/problem/15964
 */

import java.util.Scanner;

class boj15964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long A = sc.nextLong();
		Long B = sc.nextLong();

		System.out.print((A + B) * (A - B));
	}
}
