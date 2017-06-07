import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServersSocket {
	
	public static void main(String args[]) throws IOException{

	    BufferedReader in = null;
	    PrintWriter    out= null;

	    ServerSocket servers = null;
	    Socket       fromclient = null;
	    
	      servers = new ServerSocket(4444);
	      fromclient= servers.accept();

	    in  = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
	    out = new PrintWriter(fromclient.getOutputStream(),true);
	    String         input,output;

	    System.out.println("Wait for messages");
	    while ((input = in.readLine()) != null) {
	     if (input.equalsIgnoreCase("exit")) break;
	     
	     if(input.equalsIgnoreCase("1")){
	    	CallMethods.firstMethod(); 
	     }
		if(input.equalsIgnoreCase("2")){
			CallMethods.secondMethod();	 
			     }
		if(input.equalsIgnoreCase("3")){
			CallMethods.firhdMethod();
		}
	     out.println("S ::: "+input);
	     System.out.println(input);
	    }
	    out.close();
	    in.close();
	    fromclient.close();
	    servers.close();
	}

}
