package weekopdracht_extra;

abstract public class RisicoRijkeAttracties extends Attractie{
	int draaiLimiet;
	boolean opstellingsKeuring(int aantalkaartjes) {
		
		if(aantalkaartjes%draaiLimiet == 0 && aantalkaartjes != 0) {
			return true;
		}else{
			return false;
		}
	}
}
