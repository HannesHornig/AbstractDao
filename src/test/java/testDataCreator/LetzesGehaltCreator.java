package testDataCreator;

import java.util.Date;
import java.util.Random;

import domain.LetztesGehalt;

public class LetzesGehaltCreator {

	public static LetztesGehalt createLetzesGehalt() {
		Random random = new Random();
		int gehalt = random.nextInt(10000);

		LetztesGehalt letzesGehalt = new LetztesGehalt();
		letzesGehalt.setDatum(new Date());
		letzesGehalt.setGehalt(gehalt);
		return letzesGehalt;

	}

}
