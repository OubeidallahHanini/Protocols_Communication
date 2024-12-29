

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
public class Serveur {

    public static ArrayList<Compte> list;
    public static int find(message m ){
        int i =0;
        while(m.getLogin()!=list.get(i).getLogin() && m.getPasswd()!=list.get(i).getPwd()  ) {
            i++;
        }
        return i;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        list = new ArrayList<>();
        list.add(new Compte("x", "005", 10000));
        list.add(new Compte("Y", "123", 500));
        int nbConnection = 0 ;
        ServerSocket ss = new ServerSocket(2005);
        while (true){
            Socket s = ss.accept();
            ++nbConnection;
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            ObjectInputStream obin=new ObjectInputStream(s.getInputStream());
            message msg =(message) obin.readObject();
            PrintWriter pr =null;
               if (find(msg) <= nbConnection ){
                    pr.println("vous etes bien connecter");
                    pr.flush();
           }
            message msg1 =(message) obin.readObject();
               switch (msg1.getTypeOp()){
                   case 'R':
                      float x= msg.getValue()-msg1.getValue();
                      msg.setValue(x);
                      pr.println("succes");
                      pr.flush();
                      break;


               }

            }








        }









    }

