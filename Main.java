package weekopdracht_extra;

import java.util.Scanner;

public class Main {
	static boolean kermisverlaten = false;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Eigenaar eigenaar = new Eigenaar();
		Bezoeker bezoeker = new Bezoeker();
		BelastingInspecteur inspectie = new BelastingInspecteur();
		boolean kermisverlaten = false;

		while (kermisverlaten == false) {
			eigenaar.stelVragenAanBezoeker();
			int attractieKeuze = (kermisverlaten) ? -1 : bezoeker.kiesAttractie();
			if (attractieKeuze != -1) {
				eigenaar.verwerkAttractieKeuze(attractieKeuze, inspectie);
			} else {
				System.out.println("De eigenaar geeft je een hand en zegt: \"Tot de volgende keer!\"");
				kermisverlaten = true;
			}
		}
		scan.close();
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
		String input = scan.nextLine();
		if (input.length() == 0) {
			return false;
		} else {
			return true;
		}
	}
}