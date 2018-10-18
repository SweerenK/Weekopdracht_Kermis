package weekopdracht_extra;

public class Bezoeker {
	Kermis kermis = new Kermis();

	int kiesAttractie() {
		
		while (Main.kermisverlaten == false) {
			System.out.println("De eigenaar vraagt: \"In welke attractie wil je?\"");
			for (int i = 0; i < kermis.attracties.length; i++) {
				if(i == 3) {
				System.out.println();
				}
				System.out.printf((i + 1) + ". " + kermis.attracties[i].attractienaam + " (€" + "%.2f"+ ")  \t\t", kermis.attracties[i].prijs);
			}
			int attractieKeuze = Main.scan.nextInt();
			return attractieKeuze;
		}
		return -1;
	}
}
