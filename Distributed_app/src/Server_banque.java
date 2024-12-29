import com.sun.corba.se.spi.activation.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server_banque extends Thread{
    public static ArrayList<Compte> list;
    public static void main(String[] args) {
        new Server_banque().start();
        list = new ArrayList<>();
        list.add(new Compte("x", "005", 10000));
        list.add(new Compte("Y", "123", 500));
    }

    @override
    public void run(){
        try{
            int nbConnection = 0 ;
            ServerSocket ss = new ServerSocket(7777);
            while(true){
                Socket sk= ss.accept();
                ++nbConnection;
                System.out.println("client"+nbConnection+"connecter");
                new Server ThreadSocket(sk).start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

