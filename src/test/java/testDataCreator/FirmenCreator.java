package testDataCreator;

import java.util.Random;

import domain.Firma;

public class FirmenCreator {

	public static Firma createFirmaEvilCorp() {
		Firma firma = new Firma();
		firma.setBudget("100");
		firma.setFirmenname("Evil Corp");
		return firma;
	}

	public static Firma createFirma() {

		Random random = new Random();
		int budget = random.nextInt(10000);

		Firma firma = new Firma();
		firma.setBudget(Integer.toString(budget));
		firma.setFirmenname("Good Corp");
		return firma;

	}

}
