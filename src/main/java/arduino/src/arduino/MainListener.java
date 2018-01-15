package arduino;

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
		if (request.indexOf(" ") <= 0) return;
		
		String temp = request.substring(0, request.indexOf(" ")); 
		
		switch(temp) {
		
		case "CHECK":
			System.out.println("CHECK request: " + request);
			userA.Check(request.substring(request.indexOf(" ") + 1));
			if ((new Calculate()).needConserve()) remote("ALERT 5"); // blink red led
			break;
			
		case "LED":
			System.out.println(request);
			break;
			
//		case "OPEN":
//			System.out.println("OPEN request: " + request);
//			break;
//			
//		case "CLOSE":
//			System.out.println("CLOSE request: " + request);
//			break;
//			
//		case "IN":
//			System.out.println("IN request: " + request);
//			userA.Check("Door1");
//			break;
//			
//		case "OUT":
//			System.out.println("OUT request: " + request);
//			userA.Check("Door1"); 
//			break;
//			
//		default:
//			System.out.println(request);
		}
		
		
	}
	
	// send to arduino 
	public static void remote(String data) { 
		
		data = data.replaceFirst("Door1", "3");
		data = data.replaceFirst("Door2", "4");
		
		try {
			TwoWaySerialComm.pass(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		new MainListener();
        (new TwoWaySerialComm()).connect("COM9"); // connect USB COM9
        (new KeyboardControl()).run();
	}
	
}
