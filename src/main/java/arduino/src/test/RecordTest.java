package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Record.Record;

import java.util.Date;

public class RecordTest {
	public static Record DoorRecord;
	public static Record WrongRecord;
	static String[] DoorInput=new String[2];
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DoorRecord = new Record("Door","Pindar","in");
		WrongRecord=new Record();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DoorRecord = null;
		WrongRecord =null;
	}
	@Test
	public void testDoorin() throws IOException {
		String DoorResult="Pindar in"+' '+new Date()+" Access Success"+"\n"+"Door in"+' '+new Date()+" Access Success";//®É¶¡
		String DoorOutPut;

		DoorOutPut=DoorRecord.MakeTxt();
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