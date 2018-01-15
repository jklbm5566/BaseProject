package arduino;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Record {
	private String inputFilePath;
	private String inputThingfurniture;
	private String inputThinguser;
	private String outputFilePathfurniture;
	private String outputFilePathuser;
	private FileWriter textOutputfurniture;
	private FileWriter textOutputuser;
	private String inputuser;
	private String check;
	
	public Record(){
		this.inputFilePath=null;
		this.inputThingfurniture=null;
		this.inputThinguser=null;
		this.outputFilePathfurniture=null;
		this.textOutputfurniture = null;
		this.outputFilePathuser=null;
		this.inputuser=null;
		this.check=null;
	}
	public Record(String furniture,String user,String inout){
		this.inputFilePath=furniture;
		this.inputThingfurniture=inout;
		this.inputThinguser=inout;
		this.outputFilePathfurniture=inputFilePath+".txt";
		this.outputFilePathuser=user+".txt";
		this.inputuser=user;
		this.textOutputfurniture = null;
		this.textOutputuser=null;
		this.check=null;
	}
	public String MakeTxt() throws IOException {
		if(inputFilePath!=null || inputThingfurniture!=null||inputuser!=null) {
			textOutputfurniture = new FileWriter (outputFilePathfurniture,true);
			textOutputuser = new FileWriter (outputFilePathuser,true);

			inputThingfurniture=inputuser+" "+inputThingfurniture+' '+new Date() + " ";
			textOutputfurniture.write(inputThingfurniture + System.getProperty("line.separator"));
			System.out.println(inputThingfurniture + "Access Success");
			
			inputThinguser=inputFilePath+" "+inputThinguser+' '+new Date() + " ";
			textOutputuser.write(inputThinguser + System.getProperty("line.separator"));
			System.out.println(inputThinguser + "Access Success");
			
			textOutputfurniture.close();
			textOutputuser.close();
			
			
			check=inputThingfurniture+"Access Success"+"\n"+inputThinguser+"Access Success";
			return check;
		}
		else {
			System.out.print("Wrong Input");
			return "Wrong Input";
		}
	}
}