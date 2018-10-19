package weekopdracht_extra;

abstract public class RisicoRijkeAttracties extends Attractie{
	int draaiLimiet;
	boolean opstellingsKeuring(int aantalkaartjes, int resetValue) {
		
		if((aantalkaartjes-resetValue)%draaiLimiet == 0) {
			return true;
		}else{
			return false;
		}
	}
}
