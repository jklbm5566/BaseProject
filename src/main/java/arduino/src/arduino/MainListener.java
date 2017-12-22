package arduino;

import java.util.Date;

public class MainListener {
	
	public static void request(String request) { // get from arduino
		Date date = new Date();
		
		switch(request) {
		case " ": break;
		
		case "ENTER room1":
			function(request, date.toString()); // not complete yet
			break;
			
		case "CLOSE light1":
			function(request, date.toString());
			break;
			
		default:
			System.out.println("Unkown request: " + request);
		}
	}
	
	public static void remote(String data) { // send to arduino 
		TwoWaySerialComm.pass(data);
	}
	
	public static void main(String[] args) {
		
		try
	    {
	        (new TwoWaySerialComm()).connect("COM9"); // connect USB COM9
	    }
	    catch ( Exception e )
	    {
	        e.printStackTrace();
	    }
		
	}
}
