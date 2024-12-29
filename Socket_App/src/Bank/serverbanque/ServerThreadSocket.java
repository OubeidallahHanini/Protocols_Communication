/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverbanque;

import Data.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.util.ArrayList;
import serverbanque.*;
import data.*;

/**
 *
 * @author macbook
 */
public class ServerThreadSocket extends Thread {
    private Socket s ;

    public ServerThreadSocket(Socket s) {
        this.s = s;
    }
    
    @Override
    public void run (){
        try {
            // recuprer l'objet message du client 
            
            try {
                ObjectInputStream ob = new ObjectInputStream(s.getInputStream());

                Message m = (Message) ob.readObject();
                OutputStream outstream = s.getOutputStream();
                if (findClient(m.getLogin(),m.getPasswd())){

                MessageAuth m = (MessageAuth) ob.readObject();
                if (connect(m.getLogin(),m.getPasswd())){

                    System.out.println("Authentifié");
                    outstream.write(200);
                    //traiter les operations
                    m = (Message) ob.readObject();
                    treatAccount(m.getLogin(), m.getPasswd(), m.getTypeOp(),m.getValue());
                    System.out.println("Operation effectué ");
                }else{
                    System.out.println("Non Authentifié");
                    outstream.write(100);
                    //fermer la connexion
                    s.close();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerThreadSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    Boolean findClient(String login, String password){
       for (Compte temp : ServerBanque.list) {
          if (temp.getLogin().equals(login) && temp.getPasswd().equals(password)){
              return true;
          }
       }
       return false;
    }
    void treatAccount(String login, String password,char op,float value){
        //trouver le compte
        for (int i = 0; i< ServerBanque.list.size();i++) {
          if (ServerBanque.list.get(i).getLogin().equals(login) && ServerBanque.list.get(i).getPasswd().equals(password)){
            switch (op) {
            case 'R':
              float newSolde = ServerBanque.list.get(i).getSolde() - value;
              Compte element = new Compte (login,password,newSolde);
              ServerBanque.list.set(i, element);
              break;
            case 'D':
              newSolde = ServerBanque.list.get(i).getSolde() + value;
              element = new Compte (login,password,newSolde);
              ServerBanque.list.set(i, element);
              break;
            default:
            break;
        }
          }
       }
        
        

    Boolean connect(String login, String password){
	ArrayList<Compte> myList =ServerBanque.list;
	int len=myList.size();
	for(int i=0; i<len; i++) {
	    if (myList.get(i).getLogin().equals(login))
		if(myList.get(i).getPasswd().equals(password)){
		    myList.get(i).connect();
		    return true;
		} 
	}
	return false;
    }
} }}

