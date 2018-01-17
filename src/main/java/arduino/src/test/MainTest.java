package test;

import org.junit.jupiter.api.Test;

import Main.MainListener;

class MainTest {

	@Test
	void test() throws Exception {
		new MainListener();
		MainListener.main(null);
//		MainListener.remote("OPEN 5");
	}
	
}
