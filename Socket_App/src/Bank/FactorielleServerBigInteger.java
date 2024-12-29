package BANKA;

import java.lang.*;import java.io.*;
import java.net.*; import java.math.*;
public class FactorielleServerBigInteger {
    public static BigInteger factorielle (int i) {
	if (i==0) return BigInteger.ONE;
	if (i<0) return factorielle (-i);
	BigInteger b=factorielle(i-1);
	b=b.multiply(BigInteger.valueOf(i));
	return b;
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
