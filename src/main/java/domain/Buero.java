package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Buero {

	@Id
	private int bueroNummer;
	private int bueroGroesse;

	public Buero() {

	}

	public int getBueroNummer() {
		return bueroNummer;
	}

	public void setBueroNummer(int bueroNummer) {
		this.bueroNummer = bueroNummer;
	}

	public int getBueroGroesse() {
		return bueroGroesse;
	}

	public void setBueroGroesse(int bueroGroesse) {
		this.bueroGroesse = bueroGroesse;
	}

}
