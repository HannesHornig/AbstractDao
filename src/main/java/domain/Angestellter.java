package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Angestellter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int angestelltenID;
	private String name;
	@ManyToOne
	private Firma firma;
	@OneToOne(mappedBy = "angestellter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private LetztesGehalt letzesGehalt;

	public Angestellter() {

	}

	public int getAngestelltenID() {
		return angestelltenID;
	}

	public void setAngestelltenID(int angestelltenID) {
		this.angestelltenID = angestelltenID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

	public LetztesGehalt getLetzesGehalt() {
		return letzesGehalt;
	}

	public void setLetzesGehalt(LetztesGehalt letzesGehalt) {
		this.letzesGehalt = letzesGehalt;
	}

	public void addLetzesGehalt(LetztesGehalt letzesGehalt) {
		this.letzesGehalt = letzesGehalt;
		letzesGehalt.setAngestellter(this);
	}

}
