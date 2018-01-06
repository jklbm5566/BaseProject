package arduino;

import java.util.Date;

public class MainListener {
	
	public static void request(String request) throws Exception{ // get from arduino
		if (request.indexOf(" ") == -1) return;
		String temp = request.substring(0, request.indexOf(" ")); 
		String[] data = new String[2];
		
		switch(temp) {
		case " ": break;
		
		case "OPEN":
			System.out.println("OPEN request: " + request + "  at "  + (new Date()));
			data[0] = "Door"; data[1] = "in";
			(new Record(data)).MakeTxt();
			break;
			
		case "CLOSE":
			System.out.println("CLOSE request: " + request+ "  at "  + (new Date()));
			data[0] = "Door"; data[1] = "out";
			(new Record(data)).MakeTxt();
			break;
			
		case "IN":
			System.out.println("IN request: " + request);
			// function ();
			break;
			
		case "OUT":
			System.out.println("OUT request: " + request);
			// function ();
			break;
			
		default:
			System.out.println("Unknown request: " + request);
		}
	}
	
	public static void remote(String data) { // send to arduino 
		TwoWaySerialComm.pass(data);
	}
	
	public static void main(String[] args) {
		
		try
	    {
	        (new TwoWaySerialComm()).connect("COM9"); // connect USB COM9
	        
	        Thread sDebug = new SerialDebug();
	        sDebug.run();
	        
	    }
	    catch ( Exception e )
	    {
	        e.printStackTrace();
	    }
		
	}
}
