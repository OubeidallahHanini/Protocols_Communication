package BANKA;

import java.lang.*; import java.io.*; import java.net.*;

class FactorielleClient {
    
    public static void main(String args[]) throws Exception{
	Socket skt = new Socket("localhost", 7777);
	PrintWriter out=new PrintWriter(skt.getOutputStream(),true);
	BufferedReader in = new BufferedReader
	    (new InputStreamReader(skt.getInputStream()));
	out.println(10);
	System.out.println(in.readLine()+"\n"); 
	in.close();
    }
}
