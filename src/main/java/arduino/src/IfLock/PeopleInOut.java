package IfLock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Main.MainListener;
import Record.Record;

public class PeopleInOut {
	
	private String UserId;
	private boolean status = true;
	private ArrayList<DoorPosition> Door = new ArrayList<DoorPosition>();
	public Record record=new Record();
	
	/* Constructors */
	public PeopleInOut (String UserId) {
		
		this.UserId = UserId;
	}
	
	/* Accessor and mutator methods */
	public void setID(String UserId) {
		
		this.UserId = UserId;
	}
	
	public String getID() {
		
		return UserId;
	}
	
	public boolean getStatus() {
		
		return status;
	}
	
	public ArrayList<DoorPosition> getDoor() {
		
		return Door;
	}
	
	/* Change Status */
	public void ChangeStatus() {
		
		status = !status;
	}
	
	/* add UseRight and delete UseRight */
	public void addDoor(DoorPosition DoorInformation) {
		
		Door.add(DoorInformation);
	}	
	
	
	public void delDoor(DoorPosition DoorInformation) {
		
		Door.remove(DoorInformation);
	}
	
	public void resetDoor(DoorPosition DoorInformation) {
		
		delDoor(DoorInformation);
		addDoor(DoorInformation);
	}
	
	public DoorPosition Select(String doorname) {
		
		Object list[] = getDoor().toArray();
		DoorPosition[] door = Arrays.copyOf(list, list.length, DoorPosition[].class);
		
		for(int i=0; i<door.length; i++) {//select
			if(door[i].getDoorName().equals(doorname)) {
				return door[i];
			}
		}
		return null;
	}
	
	public void Check(String Input) throws InterruptedException, IOException {
		
		if(Select(Input)!=null) {
			WaitMinute(Input);
			if(Select(Input).getStatus()==getStatus()) {
				record = new Record(Select(Input).getDoorName(), getID(), "Out");
				ChangeStatus();
				record.MakeTxt();
//				System.out.println(Input + " " + getID() + " Out");
			}
			else {
				record = new Record(Select(Input).getDoorName(), getID(), "In");
				ChangeStatus();
				record.MakeTxt();
//				System.out.println(Input + " " + getID() + " In");
			}
		}
		else System.out.println("Have a Problem!");
	}
	
	public void WaitMinute(String name) throws InterruptedException {
		
		System.out.println("Open!" + name);
		MainListener.remote("OPEN " + name);
		Thread.sleep(5000);
		System.out.println("Close!" + name);
		MainListener.remote("CLOSE " + name); 
	}

}