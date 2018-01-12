package IfLock;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoorPositionTest {

	@Test
	public void Resettest() throws InterruptedException {
		
		DoorPosition door_1 = new DoorPosition("door_1", true);
		DoorPosition door_2 = new DoorPosition("door_3", true);
		
		PeopleInOut IECS = new PeopleInOut("IECS");
		PeopleInOut Chris = new PeopleInOut("Chris");
		
		IECS.addDoor(door_1);
		IECS.addDoor(door_2);
		
		Chris.addDoor(door_1);
		Chris.addDoor(door_2);
		
		door_2.setStatus(false);
		door_2.setDoorName("door_2");
		/* §ó·s */
		
		IECS.resetDoor(door_2);
		Chris.resetDoor(door_2);
		assertEquals(false, IECS.Select("door_2").getStatus());
		assertEquals(false, Chris.Select("door_2").getStatus());
		assertEquals("door_2", IECS.Select("door_2").getDoorName());
		assertEquals("door_2", IECS.Select("door_2").getDoorName());
		
		IECS.Check("door_1");
		Chris.Check("door_2");
		
		
		
	}
	
	@Test
	public void Accessormutatortest() throws InterruptedException {
		PeopleInOut IECS = new PeopleInOut("IECS");
		DoorPosition test1 = new DoorPosition("door_2", false);
		DoorPosition test2 = new DoorPosition("door_2", false);
		
		/* get and set UserId */
		IECS.setID("Chris");
		assertEquals("Chris", IECS.getID());
		
		/* get and change UserStatus */
		IECS.ChangeStatus();
		assertEquals(false, IECS.getStatus());
		IECS.ChangeStatus();
		assertEquals(true, IECS.getStatus());
		
		/* get and set DoorName */
		test1.setDoorName("door_1");
		assertEquals("door_1", test1.getDoorName());
		
		/* get and set doorStatus */
		test1.setStatus(true);
		assertEquals(true, test1.getStatus());
		assertEquals(false, test2.getStatus());
		
		/* add and delete and select door*/
		IECS.addDoor(test1);
		IECS.addDoor(test2);
		IECS.delDoor(test2);
		
		/* test error problem */
		assertEquals(null, IECS.Select("door_2"));
		IECS.Check("door_2");
		
	}
	
	

}
