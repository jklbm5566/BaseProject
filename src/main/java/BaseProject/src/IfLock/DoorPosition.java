package IfLock;

public class DoorPosition {
	
	private String DoorName;
	private boolean Status;
	
	/* Constructors */
	public DoorPosition(String DoorName, boolean Status) {
		
		this.DoorName = DoorName;
		this.Status = Status;
	}
	
	/* Accessor and mutator methods */
	public String getDoorName() {
		
		return DoorName;
	}
	
	public boolean getStatus() {
		
		return Status;
	}
	
	public void setDoorName(String DoorName) {
		
		this.DoorName = DoorName;
	}
	
	public void setStatus(boolean Status) {
		
		this.Status = Status;
	}
	

}
