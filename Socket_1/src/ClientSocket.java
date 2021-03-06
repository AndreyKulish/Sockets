import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
	
	private static String fuser,fserver;
	
	public static void main(String[] args) throws IOException {

	    System.out.println("Welcome to Client side");

	    Socket fromserver = null;
	    fromserver = new Socket("localhost",4444);
	    
	    BufferedReader in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
	    PrintWriter    out = new PrintWriter(fromserver.getOutputStream(),true);
	    BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

	    

	    while ((fuser = inu.readLine())!=null) {
	      out.println(fuser);
	      fserver = in.readLine();
	      System.out.println(fserver);
	      if (fuser.equalsIgnoreCase("close")) break;
	      if (fuser.equalsIgnoreCase("exit")) break;
	    }

	    out.close();
	    in.close();
	    inu.close();
	    fromserver.close();
	  }
	
}
