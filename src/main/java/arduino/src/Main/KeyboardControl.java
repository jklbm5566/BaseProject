package Main;

import java.util.Scanner;

import CalculatePack.Calculate;

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
               		if ((new Calculate("Door1.txt")).needConserve()) MainListener.remote("ALERT 5"); // blink red led
                
            	}
            } catch (Exception e) { }
        }
        keyboard.close();
	}
}
