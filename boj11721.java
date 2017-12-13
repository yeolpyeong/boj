/*
 * 열 개씩 끊어 출력하기
 * https://www.acmicpc.net/problem/11721
 */

package boj;

import java.util.Scanner;

public class boj11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		while (word.length() > 10) {
			System.out.println(word.substring(0, 10));
			word = word.substring(10);
		}
		System.out.println(word);
	}
}
