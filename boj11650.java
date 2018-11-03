/*
 * 좌표 정렬하기
 * https://www.acmicpc.net/problem/11650
 */

package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import javafx.util.Pair;

public class boj11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Pair<Integer, Integer>> points = new ArrayList();
		for (int i = 0; i < N; i++) {
			points.add(new Pair(sc.nextInt(), sc.nextInt()));
		}

		points.sort(new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> arg0, Pair<Integer, Integer> arg1) {
				if (arg0.getKey().equals(arg1.getKey())) {
					return arg0.getValue() - arg1.getValue();
				} else {
					return arg0.getKey() - arg1.getKey();
				}
			}
		});

		for (Pair p : points) {
			System.out.println(p.getKey() + " " + p.getValue());
		}
	}
}
