package weekopdracht_extra;

public class Bezoeker {
	Kermis kermis = new Kermis();

	int kiesAttractie() {
		
		while (Main.kermisverlaten == false) {
			System.out.println("In welke attractie wil je?");
			for (int i = 0; i < kermis.attracties.length; i++) {
				System.out.print((i + 1) + ". " + kermis.attracties[i].attractienaam + "\t\t");
			}
			int attractieKeuze = Main.scan.nextInt();
			return attractieKeuze;
		}
		return -1;
	}
}
