/*
 * 소음
 * https://www.acmicpc.net/problem/2935
 */

package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class boj2935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger A = sc.nextBigInteger();
		String O = sc.next();
		BigInteger B = sc.nextBigInteger();
		System.out.print(O.equals("+") ? A.add(B) : A.multiply(B));
	}
}
