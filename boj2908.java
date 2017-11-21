/*
 * 상수
 * https://www.acmicpc.net/problem/2908
 */

package boj;

import java.util.Scanner;

public class boj2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		String[] s1 = String.valueOf(n1).split("");
		String[] s2 = String.valueOf(n2).split("");
		
		n1 = swap(s1);
		n2 = swap(s2);
		
		System.out.println(n1>n2?n1:n2);
	}
	
	public static int swap(String[] s) {
		String temp = s[0];
		s[0] = s[2];
		s[2] = temp;
		return Integer.parseInt(s[0]+s[1]+s[2]);
	}
}
