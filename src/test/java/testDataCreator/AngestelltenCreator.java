package testDataCreator;

import java.util.List;

import domain.Angestellter;

public class AngestelltenCreator {

	public static Angestellter createAngestellenHans() {
		Angestellter angestellter = new Angestellter();
		angestellter.setName("Hans");
		return angestellter;

	}

	public static Angestellter createAngestellter() {
		Angestellter angestellter = new Angestellter();
		angestellter.setName("John Doe");
		return angestellter;

	}

	public List<Angestellter> createMultipleAngestellte() {
		return null;
	}

}
