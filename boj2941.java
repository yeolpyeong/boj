/*
 * 크로아티아 알파벳
 * https://www.acmicpc.net/problem/2941 
 */

package boj;

import java.util.Scanner;

public class boj2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(s.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "a").length());
	}
}
