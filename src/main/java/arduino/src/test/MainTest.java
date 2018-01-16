package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.MainListener;

class MainTest {

	@Test
	void test() throws Exception {
		new MainListener();
		MainListener.main(null);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	

	@AfterEach
	void tearDown() throws Exception {
		
	}
}
