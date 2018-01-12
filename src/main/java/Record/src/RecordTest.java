import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

public class RecordTest {
	public static Record DoorRecord;
	public static Record WrongRecord;
	static String[] DoorInput=new String[2];
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DoorRecord = new Record("Door","品中","in");
		WrongRecord=new Record();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DoorRecord = null;
		WrongRecord =null;
	}
	@Test
	public void testDoorin() throws IOException {
		String DoorResult="品中 in"+' '+new Date()+System.getProperty("line.separator")+"Access Success"+"\n"+"Door in"+' '+new Date()+System.getProperty("line.separator")+"Access Success";//時間
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
