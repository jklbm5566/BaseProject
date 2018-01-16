import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CalculatePack.Calculate;

class calculateTest {
	public static Calculate[] Test;
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		Test = new Calculate[13];
		Test[0] = new Calculate("Test_12.txt");
		for(int i=1;i<Test.length;i++) {
			if(i<10) Test[i] = new Calculate("Test_0"+i+".txt");
			else Test[i] = new Calculate("Test_"+i+".txt");
		}
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		for(int i=0;i<Test.length;i++) {
			Test[i].setPath(null);
		}
	}
	@Test
	void test_calculate() {
		String S = "Test_12.txt";
		assertEquals(Test[0].getPath(),S);
	}
	@Test
	void test_Month() {
		boolean Test_status = false;
		for(int i=1;i<Test.length;i++) {
			assertEquals(Test[i].needConserve(),Test_status);	
		}
	}
}
