package arduino;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Record {
	private String inputFilePath;
	private String inputThing;
	private String outputFilePath;
	private FileWriter textOutput;
	
	
	public Record(){
		this.inputFilePath=null;
		this.inputThing=null;
		this.outputFilePath=null;
		this.textOutput = null;
	}
	public Record(String[] args){
		this.inputFilePath=args[0];
		this.inputThing=args[1];
		this.outputFilePath=inputFilePath+".txt";
		this.textOutput = null;
	}
	public String MakeTxt() throws IOException {
		if(inputFilePath!=null || inputThing!=null) {
			textOutput = new FileWriter (outputFilePath,true);
			inputThing=inputThing+' '+new Date()+System.getProperty("line.separator");
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

