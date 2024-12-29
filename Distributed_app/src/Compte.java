public class Compte {
    private String login , pwd;
    private  float solde;
    private boolean connected;

    public Compte(String login, String pwd, float solde, boolean connected) {
        this.login = login;
        this.pwd = pwd;
        this.solde = solde;
        this.connected = connected;
    }

    public Compte(String x, String pwd, int solde) {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    public void disconnected(){
        this.connected=false;
    }
    public void connect(){
        this.connected=true;
    }


}
