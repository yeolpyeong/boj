/*
 * 뜨거운 붕어빵
 * https://www.acmicpc.net/problem/11945
 */

package boj;

import java.util.Scanner;

public class boj11945 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		while (sc.hasNext()) {
			System.out.println(new StringBuilder(sc.next()).reverse());
		}
	}
}
