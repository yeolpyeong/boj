/*
 * Starman
 * https://www.acmicpc.net/problem/12791
 */

package boj;

import java.util.Scanner;
import java.util.StringTokenizer;

public class boj12791 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		String albums = "1967 DavidBowie\n" + "1969 SpaceOddity\n" + "1970 TheManWhoSoldTheWorld\n" + "1971 HunkyDory\n"
				+ "1972 TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars\n" + "1973 AladdinSane\n" + "1973 PinUps\n"
				+ "1974 DiamondDogs\n" + "1975 YoungAmericans\n" + "1976 StationToStation\n" + "1977 Low\n"
				+ "1977 Heroes\n" + "1979 Lodger\n" + "1980 ScaryMonstersAndSuperCreeps\n" + "1983 LetsDance\n"
				+ "1984 Tonight\n" + "1987 NeverLetMeDown\n" + "1993 BlackTieWhiteNoise\n" + "1995 1.Outside\n"
				+ "1997 Earthling\n" + "1999 Hours\n" + "2002 Heathen\n" + "2003 Reality\n" + "2013 TheNextDay\n"
				+ "2016 BlackStar";
		StringTokenizer st = new StringTokenizer(albums);
		int[] year = new int[25];
		String[] name = new String[25];
		for (int i = 0; i < 25; i++) {
			year[i] = Integer.parseInt(st.nextToken());
			name[i] = st.nextToken();
		}

		while (Q-- > 0) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			int C = 0;
			for (int i = 0; i < 25; i++) {
				if (year[i] >= S && year[i] <= E)
					C++;
			}
			System.out.println(C);
			for (int i = 0; i < 25; i++) {
				if (year[i] >= S && year[i] <= E)
					System.out.println(year[i] + " " + name[i]);
			}
		}
	}
}
