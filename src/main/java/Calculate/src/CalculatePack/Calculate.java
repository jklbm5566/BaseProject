package CalculatePack;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculate {
	private String path; //File path
	private Scanner FileInput;//File
	private int deep;//txt的深度 
	private String[] part;
	
//	public Calculate() {
//		path = "Test_12.txt";
//		deep = 0;
//		Fileopen();
//		TOKEN();
//	}
	
	public Calculate(String path) {
		setPath(path);
		Fileopen();
		TOKEN();
	}
	
	/*有可能會需要修改文字檔檔案名稱,如果完全沒必要盪時候會全部刪除*/
	/*File Path setting method*/
	public void setPath(String path) {
//		if(path==null) return;
//		if(path.compareTo(".txt")<0) path = path + ".txt";
		this.path = path;
	}
	/*File Path editing method*/
	public String getPath() {
		return path;
	}
	
	final private void Fileopen() {
		try { FileInput = new Scanner(new FileInputStream(path)); }
		catch(FileNotFoundException e) { e.printStackTrace(); }
	}
	
	private int howDeep() {
		while(FileInput.hasNext()) {
			deep += 1;
			FileInput.nextLine();
		}
		Fileopen();
		return deep;		
	}

	private void TOKEN() {
		int i=0;
		part = new String[8 * howDeep()];
		while(FileInput.hasNext()) {
			StringTokenizer st = new StringTokenizer(FileInput.nextLine()," ");
			while(st.hasMoreTokens()) {
				part[i] = st.nextToken();
				i++;
			}
		}
	}
	
	final private double duration() {
		double du=0;
		int[] time = new int[3];
		for(int i=part.length-1;i>=0;i--) {
			int month=0;
			/* Year  ||month ||day  */
			if(i%8==7||i%8==3||i%8==4) {
				if(i>=8) {
					if(i%8==7) {
						du=(365*24);
						if(isLeapYear(part[i])) du+=24;
					
					}else if(i%8==3) {
						if(part[i].equals("Jan")) month=1;
						else if(part[i].equals("Feb")) month=2;
						else if(part[i].equals("Mar")) month=3;
						else if(part[i].equals("Apr")) month=4;
						else if(part[i].equals("May")) month=5;
						else if(part[i].equals("Jun")) month=6;
						else if(part[i].equals("Jul")) month=7;
						else if(part[i].equals("Aug")) month=8;
						else if(part[i].equals("Sep")) month=9;
						else if(part[i].equals("Oct")) month=10;
						else if(part[i].equals("Nov")) month=11;
						else month=12;
						for(int mon=1;mon<=month;mon++) {
							if(mon==1||mon==3||mon==5||mon==7||mon==8||mon==10||mon==12) du+=(31*24);
							else if(mon==4||mon==6||mon==9||mon==11) du+=(30*24);
							else if(mon==2 && isLeapYear(part[i+4])) du+=(29*24);
							else if(mon==2 && !isLeapYear(part[i+4])) du+=(28*24); 
						}
					
					}else if(i%8==4) {
						int day = 0;
						day = Integer.parseInt(part[i]);
						for(int da=1;da<day+1;da++) du+=24;
					}
				}
				else {
					if(i%8==7) {
						du-=(365*24);
						if(isLeapYear(part[i])) du-=24;
					
					}else if(i%8==3) {
						if(part[i].equals("Jan")) month=1;
						else if(part[i].equals("Feb")) month=2;
						else if(part[i].equals("Mar")) month=3;
						else if(part[i].equals("Apr")) month=4;
						else if(part[i].equals("May")) month=5;
						else if(part[i].equals("Jun")) month=6;
						else if(part[i].equals("Jul")) month=7;
						else if(part[i].equals("Aug")) month=8;
						else if(part[i].equals("Sep")) month=9;
						else if(part[i].equals("Oct")) month=10;
						else if(part[i].equals("Nov")) month=11;
						else month=12;
						for(int mon=1;mon<=month;mon++) {
							if(mon==1||mon==3||mon==5||mon==7||mon==8||mon==10||mon==12) du-=(31*24);
							else if(mon==4||mon==6||mon==9||mon==11) du-=(30*24);
							else if(mon==2 && isLeapYear(part[i+4])) du-=(29*24);
							else if(mon==2 && !isLeapYear(part[i+4])) du-=(28*24); 
						}
					
					}else if(i%8==4) {
						int day = 0;
						day = Integer.parseInt(part[i]);
						for(int da=1;da<day+1;da++) du-=24;
					}
				}
			}
			/*time[3]={"hour=[0]","min=[1]","sec=[2]"} */
			else if(i%8==5) {
				StringTokenizer st = new StringTokenizer(part[i],":");
				if(i>=8) {
					for(int t=0;t<time.length;t++) {
						time[t]=Integer.parseInt(st.nextToken());
						if(t==0) du+=time[t];
						else if(t==1) du+=time[t]/60;
						else du+=time[t]/3600;
					}
				}
				else {
					for(int t=0;t<time.length;t++) {
						time[t]=Integer.parseInt(st.nextToken());
						if(t==0) du-=time[t];
						else if(t==1) du-=time[t]/60;
						else du-=time[t]/3600;
					}
				}
			}
		}
		return du;
	}
	
	private boolean isLeapYear(String year_in_String) {
		int year_in_int=0;
		year_in_int = Integer.parseInt(year_in_String);
		
		if(year_in_int%4==0) return true;
		else return false;
	}
	
	/*consider whether power conservation or not*/
	public boolean needConserve() {
		/* W = w * time, if W>=MAX return true , else return false */
		int w = 100, MAX = 2401;
		return MAX <= w*duration();
	}

}
