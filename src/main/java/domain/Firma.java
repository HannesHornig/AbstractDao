package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Firma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int umsatzSteuerID;
	private String firmenname;
	private String budget;
	@OneToMany(mappedBy = "firma", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Angestellter> angestellte = new ArrayList<>();

	public Firma() {

	}

	public int getUmsatzSteuerID() {
		return umsatzSteuerID;
	}

	public void setUmsatzSteuerID(int umsatzSteuerID) {
		this.umsatzSteuerID = umsatzSteuerID;
	}

	public String getFirmenname() {
		return firmenname;
	}

	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public List<Angestellter> getAngestellte() {
		return angestellte;
	}

	public void setAngestellte(List<Angestellter> angestellte) {
		this.angestellte = angestellte;
	}

	public void addAngestellter(Angestellter angestellter) {
		angestellte.add(angestellter);
		angestellter.setFirma(this);
	}

	public void removeAngestellter(Angestellter angestellter) {
		angestellte.remove(angestellter);
		angestellter.setFirma(null);
	}

	@Override
	public String toString() {
		return "Firma [umsatzSteuerID=" + umsatzSteuerID + ", firmenname=" + firmenname + ", budget=" + budget
				+ ", angestellte=" + angestellte + "]";
	}

}
