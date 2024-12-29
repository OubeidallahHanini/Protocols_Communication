/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbook
 */
public class Clientbanque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            Socket ss = new Socket("localhost", 5000);
            Scanner sc = new Scanner(System.in);
            InputStream is = ss.getInputStream();
            OutputStream os = ss.getOutputStream();
            System.out.println("Entrez votre pseudo");
            String lg = sc.nextLine();
            System.out.println("Entrez votre password");
            String pass = sc.nextLine();
            message msg = new message(lg, pass);
            ObjectOutputStream ob = new ObjectOutputStream(ss.getOutputStream());
            //envoyer le message sur la canal
            ob.writeObject(msg);
            // recuperer le message de succes

            //traiter les operations sur le compte
            try {
                InputStream in = ss.getInputStream();
                int status;
                float valeur;
                status = in.read();
                System.out.println("status "+ status);
                if (status == 200){
                    System.out.println("Entrez la nature de l'operation");
                    System.out.println("Retrait(R)/Depos(D)/Consulter(C)");
                    String op = sc.next();
                    switch (op){
                        case "R":
                            System.out.println("Donnez la somme a retirer");
                            valeur = sc.nextFloat();
                            msg = new message(lg,pass,'R',valeur);
                            ob.writeObject(msg);
                            break;
                        case "D":
                            System.out.println("Donnez la somme a deposer");
                            valeur = sc.nextFloat();
                            msg = new message(lg,pass,'D',valeur);
                            ob.writeObject(msg);
                            break;
                        case "C":
                            msg = new message(lg,pass,'C');
                            ob.writeObject(msg);
                            break;
                        default:
                            break;
                    }
                }else{
                    System.out.println("login/password erronè");
                }
            } catch (IOException ex) {
                Logger.getLogger(Clientbanque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Clientbanque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
