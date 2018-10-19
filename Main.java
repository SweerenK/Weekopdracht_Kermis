package weekopdracht_extra;

import java.util.Scanner;

public class Main {
	static boolean kermisverlaten = false;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Eigenaar eigenaar = new Eigenaar();
		Bezoeker bezoeker = new Bezoeker();
		BelastingInspecteur inspectie = new BelastingInspecteur();

		System.out.println(
				"Het is een prachtige dag om naar de kermis te gaan.\nHoeveel geld wil je meenemen? (tip: minimaal 100 euro)");
		int bedrag = scan.nextInt();
		scan.nextLine();
		bezoeker.setBedragOpZak(Double.parseDouble(Integer.toString(bedrag)));

		System.out.println("\nJe loopt de kermis op en ziet de eigenaar verschijnen.");
		while (kermisverlaten == false) {
			Double goedkoopsteAttractie = 100.00;
			for (int j = 0; j < Kermis.attracties.length; j++) {
				if (Kermis.attracties[j].prijs < goedkoopsteAttractie) {
					goedkoopsteAttractie = Kermis.attracties[j].prijs;
				}
			}

			eigenaar.stelVragenAanBezoeker(bezoeker);

			int attractieKeuze = (kermisverlaten) ? -1 : bezoeker.kiesAttractie();

			if (bezoeker.controleerPortemonnee(attractieKeuze, goedkoopsteAttractie)) {
				eigenaar.verwerkAttractieKeuze(attractieKeuze, inspectie);
			}
			if (kermisverlaten) {
				System.out.println("Eigenaar:\t\"Tot de volgende keer!\"");
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