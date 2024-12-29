package BANKA;

import java.lang.*;import java.io.*;
import java.net.*;
public class FactorielleServer {
    public static int factorielle (int i) {
	if (i==0) return 1;
	if (i<0) return factorielle (-i);
	if (i>12) return -1; // On ne peut pas calculer pour les
			     // grands nombres

	return i*factorielle(i-1);
    }

    public static void main(String args[]) throws Exception {
       ServerSocket srvr = new ServerSocket(7777);
       while(true){
	   Socket skt = srvr.accept();
	   BufferedReader in = new BufferedReader
	       (new InputStreamReader(skt.getInputStream()));
	   PrintWriter out = new PrintWriter(skt.getOutputStream(),true);
	   int var =Integer.parseInt(in.readLine());
	   out.print(factorielle(var));
	   out.close(); skt.close();
       }
   }
}
