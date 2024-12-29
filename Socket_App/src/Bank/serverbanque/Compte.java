/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverbanque;

/**
 *
 * @author macbook
 */
public class Compte {
    private String login,passwd;
    private float solde;
    private boolean connected; //etat du client 

    public Compte(String login, String passwd, float solde) {
        this.login = login;
        this.passwd = passwd;
        this.solde = solde;
	connected=false;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }

    public float getSolde() {
        return solde;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public void connect() {
        this.connected=true;
    }

    public void disconnect() {
        this.connected=false;
    }

    public boolean  isConnected() {
        return connected;
    }

    
}
