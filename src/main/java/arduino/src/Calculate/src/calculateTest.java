import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CalculatePack.Calculate;

class calculateTest {
	public static Calculate Test;
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		Test = new Calculate("Test_12.txt");
//	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		Test.setPath(null);
	}

//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
	@Test
	void test_Jan() {
		boolean Test_status = false;
		Test = new Calculate("Test_01.txt");
		assertEquals(Test.needConserve(),Test_status);		
	}
	
	@Test
	void test_Feb() {
		boolean Test_status = false;
		Test = new Calculate("Test_02.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_Mar() {
		boolean Test_status = false;
		Test = new Calculate("Test_03.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_Apr() {
		boolean Test_status = false;
		Test = new Calculate("Test_04.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_May() {
		boolean Test_status = false;
		Test = new Calculate("Test_05.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_Jun() {
		boolean Test_status = false;
		Test = new Calculate("Test_06.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_Jul() {
		boolean Test_status = false;
		Test = new Calculate("Test_07.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_Aug() {
		boolean Test_status = false;
		Test = new Calculate("Test_08.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_Sep() {
		boolean Test_status = false;
		Test = new Calculate("Test_09.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_Oct() {
		boolean Test_status = false;
		Test = new Calculate("Test_10.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_Nov() {
		boolean Test_status = false;
		Test = new Calculate("Test_11.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_Dec() {
		boolean Test_status = false;
		Test = new Calculate("Test_12.txt");
		assertEquals(Test.needConserve(),Test_status);	
	}
	@Test
	void test_getPath() {
		Test = new Calculate("Test_12.txt");
		String testS = "Test_12.txt";
		assertEquals(Test.getPath(),testS);	
	}
}
