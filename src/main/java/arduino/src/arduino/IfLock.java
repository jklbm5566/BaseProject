//package arduino;
//
//class MyThread extends Thread {
//	
//	public void run(){
//		
//	  //System.out.println("First!");
//		MainListener.remote("Open 4"); //開鎖
//	    try {
//	    	
//	    	sleep(60000);//計時1分鐘
//	    }catch(Exception e) {
//	    		
//	    	e.printStackTrace();
//	    }
//	   	//System.out.println("Second!");
//	    MainListener.remote("Close"); //上鎖
//	}
//}
//
//public class IfLock {
//	
//	public void check(String Input) {
//		
//		boolean[] InOut = new boolean[4];//false = Out, true = In
//		InOut[0] = true;//假設在客廳,door_0為大門。
//		Thread Send = new MyThread();
//		
//		switch(Input) {
//			
//			case "door_0":
//				
//				Send.start();
//				if(InOut[0]==true) {
//					
////					record("door_0", "false");//出門
//					InOut[0] = false;
//				}
//				else {
//					
////					record("door_0", "true");//進門
//					InOut[0] = true;
//				}
//			case "door_1":
//				
//				Send.start();
//				if(InOut[1]==true) {
//					
////					record("door_0", "false");//出門
//					InOut[1] = false;
//				}
//				else {
//					
////					record("door_0", "true");
//					InOut[1] = true;
//				}
//			case "door_2":
//				
//				Send.start();
//				if(InOut[2]==true) {
//					
////					record("door_0", "false");//出門
//					InOut[2] = false;
//				}
//				else {
//					
////					record("door_0", "true");
//					InOut[2] = true;
//				}
//			case "door_3":
//				
//				Send.start();
//				if(InOut[3]==true) {
//					
////					record("door_0", "false");//出門
//					InOut[3] = false;
//				}
//				else {
//					
////					record("door_0", "true");
//					InOut[3] = true;
//				}
//			}
//	}
//			public static void test() {
//				Thread Send = new MyThread();
//				
//				Send.;
//				System.out.println("test");
//			}
//			
//			public static void main(String[] args) {//此區測試使用
//				
//				Thread Send = new MyThread();
//				
//				test();
//				
//			}
//}
//
