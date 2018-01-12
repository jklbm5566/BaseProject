package arduino;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
 
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
 
public class TwoWaySerialComm {
	
	private static InputStream in;
	private static OutputStream out;
	
	
    public TwoWaySerialComm()
    {
        super();
    }
     
    public void connect ( String portName ) throws Exception
    {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);

        CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);

        SerialPort serialPort = (SerialPort) commPort;
        serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
         
        in = serialPort.getInputStream();
        out = serialPort.getOutputStream();
         
        (new Thread(new SerialReader(in))).start();

     
    }
     
    public static void pass(String data) throws IOException{
      
		for (int i = 0; i < data.length(); i++) out.write(data.charAt(i));
		out.write('\n');
        
    }
    
    public static class SerialReader implements Runnable 
    {
        InputStream in;
         
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
         
        public void run()
        {
            byte[] buffer = new byte[1024];
            String temp;
            int len = -1;
            try
            {
                while ( true )
                {
                	len = this.in.read(buffer);
                	if (len > -1) {
                		temp = new String(buffer, 0, len);
                		if (len == 1) temp += new String(buffer, 0, len = this.in.read(buffer)); // make sure no single char
                    	if (!temp.isEmpty()) 
                    		try {
                    			MainListener.request(temp);
                    		}
                    		catch (Exception e)  {
                    			e.printStackTrace();
                    		}
                	}
                }
            } 
            catch ( IOException e )
            {
                e.printStackTrace();
            }           
        }
    }
     
}