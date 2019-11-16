package hibernateTest.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.FirmenDao;
import domain.Firma;
import testDataCreator.FirmenCreator;

public class FirmenDaoTest {

	private final FirmenDao dao = new FirmenDao();

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {
		dao.deleteTableContent();
	}

	@Test
	public void insertFirma() {
		Firma insertedFirma = FirmenCreator.createFirmaEvilCorp();
		dao.insert(insertedFirma);
	}

	@Test
	public void findFirma() {
		Firma insertedFirma = FirmenCreator.createFirmaEvilCorp();
		dao.insert(insertedFirma);
		Firma foundFirma = dao.find(insertedFirma.getUmsatzSteuerID());
		Assert.assertEquals(insertedFirma, foundFirma);
	}

	@Test
	public void deleteFirma() {
		Firma firmaToDelete = FirmenCreator.createFirmaEvilCorp();
		dao.insert(firmaToDelete);
		dao.delete(firmaToDelete);
		Firma notFound = dao.find(firmaToDelete.getUmsatzSteuerID());
		Assert.assertNull(notFound);
	}

	@Test
	public void deleteContentTableFirma() {
		Firma insertedFirma = FirmenCreator.createFirmaEvilCorp();
		dao.insert(insertedFirma);
		int numberAffectedRows = dao.deleteTableContent();
		Assert.assertEquals(1, numberAffectedRows);
	}

}
