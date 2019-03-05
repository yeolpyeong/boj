
/*
 * CASIO
 * https://www.acmicpc.net/problem/15963
 */

import java.util.Scanner;

class boj15963 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long N = sc.nextLong();
		Long M = sc.nextLong();
		
		System.out.print(N - M == 0 ? 1 : 0);
	}
}
