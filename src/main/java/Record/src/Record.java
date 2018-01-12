import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Record {
	private String inputFilePath;
	private String inputThing;
	private String outputFilePath;
	private FileWriter textOutput;
	private String inputuser;
	
	public Record(){
		this.inputFilePath=null;
		this.inputThing=null;
		this.outputFilePath=null;
		this.textOutput = null;
		this.inputuser=null;
	}
	public Record(String furniture,String user,String inout){
		this.inputFilePath=furniture;
		this.inputThing=inout;
		this.outputFilePath=inputFilePath+".txt";
		this.inputuser=user;
		this.textOutput = null;
	}
	public String MakeTxt() throws IOException {
		if(inputFilePath!=null || inputThing!=null||inputuser!=null) {
			textOutput = new FileWriter (outputFilePath,true);
			inputThing=inputuser+" "+inputThing+' '+new Date()+System.getProperty("line.separator");
			textOutput.write(inputThing);
			System.out.print(inputThing);
			System.out.println("Access Success");
			textOutput.close();
			return inputThing;
		}
		else {
			System.out.print("Wrong Input");
			return "Wrong Input";
		}
	}
}
