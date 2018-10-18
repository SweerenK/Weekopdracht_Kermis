package weekopdracht_extra;

import java.util.Scanner;

public class Main {
	static boolean kermisverlaten = false;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Eigenaar eigenaar = new Eigenaar();
		Bezoeker bezoeker = new Bezoeker();
		boolean kermisverlaten = false;
		boolean doorvragen = true;

		while (kermisverlaten == false) {
			eigenaar.stelVragenAanBezoeker();
			int attractieKeuze = (kermisverlaten) ? -1 : bezoeker.kiesAttractie();
			if (attractieKeuze != -1) {
				eigenaar.verwerkAttractieKeuze(attractieKeuze);
			} else {
				kermisverlaten = true;
			}
		}
	}

	static boolean verlaatKermis() {
		if (scan.nextLine().equals("q")) {
			System.out.println("Je verlaat de kermis.");
			return true;
		} else {
			return false;
		}
	}

	static boolean pressEnter() {
		System.out.println("\t(Druk op enter om door te gaan..)");
		scan.nextLine();
		if (scan.nextLine().length() == 0) {
			return false;
		} else {
			return true;
		}
	}
}
