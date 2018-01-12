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
		
		delay(7000); 
		MainListener.remote("BLINK 3");
		delay(5000);
	}
}
