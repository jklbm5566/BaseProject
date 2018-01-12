package test;

import java.io.IOException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import arduino.MainListener;
import arduino.SerialDebug;
import arduino.TwoWaySerialComm;

class MainTest {

	@Test
	void test() throws Exception {
		MainListener.main(null);
		MainListener.request("OPEN ");
		MainListener.request("CLOSE ");
		MainListener.request("IN ");
		MainListener.request("OUT ");
		MainListener.request(" ");
		MainListener.request("oeifnoe");

        (new SerialDebug()).run();

	}
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}
}
