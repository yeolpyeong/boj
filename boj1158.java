/*
 * 조세퍼스 문제
 * https://www.acmicpc.net/problem/1158
 */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Queue<Integer> q = new LinkedList();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		String s = "<";
		while (!q.isEmpty()) {
			for (int i = 1; i < M; i++) {
				q.add(q.poll());
			}
			s += q.poll() + ", ";
		}
		System.out.print(s.substring(0, s.length() - 2) + ">");
	}
}
