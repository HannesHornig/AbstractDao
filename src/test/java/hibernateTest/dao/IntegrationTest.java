package hibernateTest.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.AngestelltenDao;
import dao.FirmenDao;
import dao.LetztesGehaltDao;
import domain.Angestellter;
import domain.Firma;
import domain.LetztesGehalt;
import testDataCreator.AngestelltenCreator;
import testDataCreator.FirmenCreator;
import testDataCreator.LetzesGehaltCreator;

public class IntegrationTest {

	private final FirmenDao daoFirma = new FirmenDao();
	private final AngestelltenDao daoAngestellter = new AngestelltenDao();
	private final LetztesGehaltDao daoLetzesGehalt = new LetztesGehaltDao();

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}

	@Test
	public void insertFirmaMitAngestellten() {
		Firma firma = FirmenCreator.createFirma();
		Angestellter angstellter = AngestelltenCreator.createAngestellter();
		firma.addAngestellter(angstellter);
		daoFirma.insert(firma);
		daoAngestellter.deleteTableContent();
		daoFirma.deleteTableContent();

	}

	@Test
	public void insertAngestellterMitLetztemGehalt() {
		Angestellter angestellter = AngestelltenCreator.createAngestellter();
		LetztesGehalt letztesGehalt = LetzesGehaltCreator.createLetzesGehalt();
		angestellter.addLetzesGehalt(letztesGehalt);
		daoAngestellter.insert(angestellter);
		daoLetzesGehalt.deleteTableContent();
		daoAngestellter.deleteTableContent();

	}

	@Test
	public void insertFirmaMitAngestelltenMitLetzemGehalt() {
		Firma firma = FirmenCreator.createFirma();
		Angestellter angestellter = AngestelltenCreator.createAngestellter();
		LetztesGehalt letztesGehalt = LetzesGehaltCreator.createLetzesGehalt();

		angestellter.addLetzesGehalt(letztesGehalt);
		firma.addAngestellter(angestellter);
		daoFirma.insert(firma);

		daoLetzesGehalt.deleteTableContent();
		daoAngestellter.deleteTableContent();
		daoFirma.deleteTableContent();

	}

}
