/*
 * 국영수
 * https://www.acmicpc.net/problem/10825
 */

package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class boj10825 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		class Score {
			String name;
			int korean;
			int english;
			int math;

			public Score(String name, int korean, int english, int math) {
				this.name = name;
				this.korean = korean;
				this.english = english;
				this.math = math;
			}
		}
		ArrayList<Score> score = new ArrayList();
		for (int i = 0; i < N; i++) {
			score.add(new Score(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		score.sort(new Comparator<Score>() {
			@Override
			public int compare(Score arg0, Score arg1) {
				if (arg0.korean == arg1.korean) {
					if (arg0.english == arg1.english) {
						if (arg0.math == arg1.math) {
							return arg0.name.compareTo(arg1.name);
						} else {
							return arg1.math - arg0.math;
						}
					} else {
						return arg0.english - arg1.english;
					}
				} else {
					return arg1.korean - arg0.korean;
				}
			}
		});

		for (Score s : score) {
			System.out.println(s.name);
		}
	}
}
