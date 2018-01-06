package arduino;

public class SerialDebug extends Thread {
	
	public void delay(int time) {
		try {
	    	sleep(time);
	    }catch(Exception e) {
	    		
	    	e.printStackTrace();
	    }
	}
	public void run() {
		
//	    for (int i = 0; i < 45; i++) {
//	    	MainListener.remote("OPEN 5"); 
//	    	delay(2000); 
//		    MainListener.remote("OPEN 4"); 
//		    delay(2000);
//		    MainListener.remote("OPEN 3");
//		    delay(2000);
//		    MainListener.remote("CLOSE 3");
//		    delay(2000);
//		    MainListener.remote("CLOSE 4");
//		    delay(2000);
//		    MainListener.remote("CLOSE 5");
//		    delay(2000);
//		    
//	    }
		delay(7000); 
		MainListener.remote("BLINK 3");
		delay(5000);
	}
}
