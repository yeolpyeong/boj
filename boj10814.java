/*
 * 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 */

package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import javafx.util.Pair;

public class boj10814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Pair<Integer, String>> list = new ArrayList();
		for (int i = 0; i < N; i++) {
			list.add(new Pair(sc.nextInt(), sc.next()));
		}

		list.sort(new Comparator<Pair<Integer, String>>() {
			@Override
			public int compare(Pair<Integer, String> arg0, Pair<Integer, String> arg1) {
				return arg0.getKey() - arg1.getKey();
			}
		});

		for (Pair p : list) {
			System.out.println(p.getKey() + " " + p.getValue());
		}
	}
}
