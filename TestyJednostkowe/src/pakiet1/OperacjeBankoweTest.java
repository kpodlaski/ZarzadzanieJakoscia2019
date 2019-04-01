package pakiet1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperacjeBankoweTest {

	OperacjeBankowe operBank;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		operBank= new OperacjeBankowe();
	}

	@After
	public void tearDown() throws Exception {
		operBank = null;
	}

	@Test
	public void testProcentZlozony() throws Exception {
		double wynik = operBank.procentZlozony(1000, 0.1, 1);
		double wynikOczekiwany = 100;
		assertEquals(wynikOczekiwany, wynik,0.01);
	}

	@Test
	public void testProcentZlozony2() throws Exception {
		double wynik = operBank.procentZlozony(1000, 0.1, 2);
		double wynikOczekiwany = 110;
		assertEquals(wynikOczekiwany, wynik,0.01);
	}
	
	@Test
	public void testProcentZlozony3() throws Exception {
		double wynik = operBank.procentZlozony(1000, 0.1, 0);
		double wynikOczekiwany = 0.0;
		assertEquals(wynikOczekiwany, wynik,0.01);
	}
	
	@Test(expected = Exception.class)
	public void testZbytDuzeOprocentowanie() throws Exception{
		double wynik = operBank.procentZlozony(1000, 1.1, 1);
		double wynikOczekiwany = 1100;
		assertEquals(wynikOczekiwany, wynik,0.01);
	}
}
