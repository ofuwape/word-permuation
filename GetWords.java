package second;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GetWords {
	public static Set<String> getAllWords(String str) {
		Set<String> perm = new HashSet<String>();
		// special cases
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		} else if (str.length() == 1) {
			perm.add(str);
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		System.out.println("initial: " + initial);
		System.out.println("rem: " + rem);
		Set<String> words = getAllWords(rem);
		for (String strNew : words) {
			System.out.println("strNew: " + strNew);
			for (int i = 0; i <= strNew.length(); i++) {
				System.out.println(initial + " " + i);
				perm.add(placeChar(strNew, initial, i));
			}
		}
		return perm;
	}

	public static String placeChar(String str, char c, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}

	public static void main(String[] args) {

		// assuming a dictionary is created by user
		// program will check if word is in dictionary before printing out each
		// word
		Scanner scan = new Scanner(System.in);
		System.out.println(getAllWords(scan.next()).size());
	}
}