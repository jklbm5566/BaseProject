package arduino;

import java.util.Scanner;

public class KeyboardControl extends Thread {
	public void run() {
			
		Scanner keyboard = new Scanner(System.in);
        String cmd;
        
        while (true) {
        	try {
        		cmd = keyboard.nextLine();
            	if (cmd.equals("END")) break;
            	else {
               		MainListener.remote(cmd);
               		MainListener.userA.Check(cmd);
                
            	}
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
        keyboard.close();
	}
}
