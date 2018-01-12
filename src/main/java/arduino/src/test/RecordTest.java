package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import arduino.Record;

import java.util.Date;

public class RecordTest {
	public static Record DoorRecord;
	public static Record WrongRecord;
	static String[] DoorInput=new String[2];
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DoorInput[0]="Door";
		DoorInput[1]="in";
		DoorRecord = new Record(DoorInput);
		WrongRecord=new Record();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DoorRecord = null;
		WrongRecord =null;
	}
	@Test
	public void testDoorin() throws IOException {
		String DoorResult=DoorInput[1]+' '+new Date()+System.getProperty("line.separator");//時間
		String DoorOutPut;
		
		DoorOutPut=DoorRecord.MakeTxt();
		System.out.println();
		assertEquals(DoorResult,DoorOutPut);
	}
	@Test
	public void testWrong() throws IOException {
		String WrongResult="Wrong Input";
		String WrongOutPut;
		
		WrongOutPut=WrongRecord.MakeTxt();
		System.out.println();
		assertEquals(WrongResult,WrongOutPut);
	}
}

