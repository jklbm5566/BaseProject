package Main;

import java.io.IOException;

import CalculatePack.Calculate;
import IfLock.*;

public class MainListener {
	public static PeopleInOut userA;
	public static String[] Appliances;
	
	
	public MainListener() {
		userA = new PeopleInOut("001");
		
		DoorPosition Door1 = new DoorPosition("Door1", true);
		DoorPosition Door2 = new DoorPosition("Door2", true);
		
		userA.addDoor(Door1);
		userA.addDoor(Door2);
	}
	
	// get from arduino
	public static void request(String request) throws InterruptedException, IOException {
//		if (request.indexOf(" ") <= 0) return;
		
		String temp = request.substring(0, request.indexOf(" ")); 
		
		switch(temp) {
		
		case "CHECK":
			System.out.println("CHECK request: " + request);
			userA.Check(request.substring(request.indexOf(" ") + 1));
			if ((new Calculate("Door1.txt")).needConserve()) remote("ALERT 5"); // blink red led 
			break;
			
		case "LED":
			System.out.println(request);
			break;

		}
	}
	
	// send to arduino 
	public static void remote(String data) { 
		
		data = data.replaceFirst("Door1", "3");
		data = data.replaceFirst("Door2", "4");
		data = data.replaceFirst("door_1", "3");
		data = data.replaceFirst("door_2", "4");
		
		
		TwoWaySerialComm.pass(data);
	}
	
	public static void main(String[] args) throws Exception{
		new MainListener();
        (new TwoWaySerialComm()).connect("COM9"); // connect USB COM9
        (new KeyboardControl()).run();
	}
	
}
