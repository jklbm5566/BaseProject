package arduino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void test() {
		try {
			MainListener.main(null);
			MainListener.request("OPEN ");
			MainListener.request("CLOSE ");
			MainListener.request("IN ");
			MainListener.request("OUT ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	@Test
//	void test2() {
//		try {
//	        (new TwoWaySerialComm()).connect("COM9"); // connect USB COM9
//	    } catch ( Exception e ) {
//	        e.printStackTrace();
//	    }
//	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
}
