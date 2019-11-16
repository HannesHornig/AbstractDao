package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LetztesGehalt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gehaltsNummer;
	private int gehalt;
	private Date datum;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Angestellter angestellter;

	public LetztesGehalt() {

	}

	public int getGehaltsNummer() {
		return gehaltsNummer;
	}

	public void setGehaltsNummer(int gehaltsNummer) {
		this.gehaltsNummer = gehaltsNummer;
	}

	public int getGehalt() {
		return gehalt;
	}

	public void setGehalt(int gehalt) {
		this.gehalt = gehalt;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Angestellter getAngestellter() {
		return angestellter;
	}

	public void setAngestellter(Angestellter angestellter) {
		this.angestellter = angestellter;
	}

	public void addAngestellter(Angestellter angestellter) {
		this.angestellter = angestellter;
		angestellter.setLetzesGehalt(this);

	}

}
