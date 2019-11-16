package hibernateTest.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.AngestelltenDao;
import domain.Angestellter;
import testDataCreator.AngestelltenCreator;

public class AngestelltenDaoTest {

	private final AngestelltenDao dao = new AngestelltenDao();

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {
		dao.deleteTableContent();
	}

	@Test
	public void insertAngestellter() {
		Angestellter angestellter = AngestelltenCreator.createAngestellenHans();
		dao.insert(angestellter);
	}

	@Test
	public void dropTableContentAngestellterBulkOperation() {
		Angestellter angestellter = AngestelltenCreator.createAngestellenHans();
		dao.insert(angestellter);
		int nummerGeloeschteAngestellte = dao.deleteTableContent();
		Assert.assertEquals(1, nummerGeloeschteAngestellte);
	}

}
